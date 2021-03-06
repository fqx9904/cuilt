/*
 *  @author Philip Stutz
 *  @author Mihaela Verman
 *  
 *  Copyright 2015 University of Zurich
 *      
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *         http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 */

package com.signalcollect.dcop.modules

import scala.util.Random

/**
 * The module. Contains methods that are usually used by decision rules.
 */

trait DecisionRule extends Algorithm {

  def computeMove(c: State): Action

  def isInLocalOptimum(c: State): Boolean = {
    val expectedUtilities: Map[Action, Double] = computeExpectedUtilities(c)
    val maxUtility = expectedUtilities.values.max
    val res = isInLocalOptimumGivenUtilitiesAndMaxUtility(c, expectedUtilities, maxUtility)
    //        if (!res) 
    //          println("###DecisionRule.isInLocalOptimum"+c.agentId+"->"+c.centralVariableValue+": util: "+expectedUtilities.toString)
    res
  }

  protected final def isInLocalOptimumGivenUtilitiesAndMaxUtility(
    c: State,
    expectedUtilities: Map[Action, Double],
    maxUtility: Double): Boolean = {
    val currentUtility = expectedUtilities(c.centralVariableValue)
    maxUtility == currentUtility
  }
}

/**
 * Decision rule implementations
 */

trait ArgmaxADecisionRule extends DecisionRule {

  def computeMove(c: State) = {
    val expectedUtilities: Map[Action, Double] = computeExpectedUtilities(c)
    val maxUtility = expectedUtilities.values.max
    if (isInLocalOptimumGivenUtilitiesAndMaxUtility(c, expectedUtilities, maxUtility)) {
      c.centralVariableValue
    } else {
      val maxUtilityMoves: Seq[Action] = expectedUtilities.filter(_._2 == maxUtility).map(_._1).toSeq
      if (maxUtilityMoves.size <= 0) println(expectedUtilities)
      assert(maxUtilityMoves.size > 0)
      val chosenMaxUtilityMove = maxUtilityMoves(Random.nextInt(maxUtilityMoves.size))
      chosenMaxUtilityMove
    }
  }

}

trait ArgmaxBDecisionRule extends DecisionRule {

  def computeMove(c: State) = {
    val expectedUtilities: Map[Action, Double] = computeExpectedUtilities(c)
    val maxUtility = expectedUtilities.values.max
    val maxUtilityMoves: Seq[Action] = expectedUtilities.filter(_._2 == maxUtility).map(_._1).toSeq
    val numberOfMaxUtilityMoves = maxUtilityMoves.size

    //If we are converged already don't stir the boat
    // Attention! If isConverged no longer depends on the utility so 
    // the maxUtility move may not be the current move anymore...
    if ((isInLocalOptimumGivenUtilitiesAndMaxUtility(c, expectedUtilities, maxUtility)) &&
      (maxUtilityMoves.contains(c.centralVariableValue)) &&
      (c.computeExpectedNumberOfConflicts == 0)) {
      c.centralVariableValue
    } else {
      val chosenMaxUtilityMove = maxUtilityMoves(Random.nextInt(maxUtilityMoves.size))
      chosenMaxUtilityMove
    }
  }

}

trait SimulatedAnnealingDecisionRule extends DecisionRule with StateWithMemory {

  def const: Double
  def k: Double

  def etaInverse(i: Long) = {
    val iToK = math.pow(i, k)
    assert(math.pow(i, 2) == i * i)
    iToK / const
  }
  //var deltaComp = 0.0
  def negDeltaMax: Double
  assert(negDeltaMax < 0, "negDeltaMax must be smaller than 0.")

  override def computeMove(c: State) = {
    //    println("Iteration in computeMove:" + c.agentId + "-" + c.numberOfCollects)
    val randomMove = c.domain.toSeq(Random.nextInt(c.domain.size))
    val expectedUtilities = computeExpectedUtilities(c).toMap[Action, Double]
    val delta = expectedUtilities.getOrElse[Double](randomMove, -1) - expectedUtilities.getOrElse[Double](c.centralVariableValue, -1)
    //deltaComp = delta
    val probab = if (delta == 0) scala.math.exp(negDeltaMax * etaInverse(c.numberOfCollects)) else scala.math.exp(delta * etaInverse(c.numberOfCollects))
    if (delta > 0 || (delta <= 0 && Random.nextDouble <= probab)) {
      randomMove
    } else {
      c.centralVariableValue
    }
  }

}

trait LinearProbabilisticDecisionRule extends DecisionRule {

  /*
   * In the case where we have a flat distribution and normFactor would be 0, the function should return the first action. 
   */
  override def computeMove(c: State): Action = {
    val expectedUtilities: Map[Action, Double] = computeExpectedUtilities(c)
    assert(expectedUtilities.values.forall(_ >= 0))
    val scaleFactor = expectedUtilities.values.sum
    val intervalSelector = Random.nextDouble * scaleFactor

    if (scaleFactor == 0.0) return c.centralVariableValue

    var partialSum: Double = 0.0
    for (action <- expectedUtilities.keys) {
      partialSum += expectedUtilities(action)
      if (intervalSelector <= partialSum) {
        return action
      }
    }
    throw new Exception("This code should be unreachable.")
  }

}

trait LogisticDecisionRule extends ArgmaxADecisionRule {

  def eta: Double

  /*
   * In the case where we have a flat distribution and normFactor would be 0, the function should return the first action. 
   */
  override def computeMove(c: State): Action = {

    if (eta < 0.5) {
      super.computeMove(c)
    } else {
      val expectedUtilities: Map[Action, Double] = computeExpectedUtilities(c)
      assert(expectedUtilities.values.forall(_ >= 0))
      val scaleFactor = expectedUtilities.values.map(v => math.exp(v / eta)).sum
      //if (c.agentId == 1)
       // println(c.agentId+"scaleFactor = " + scaleFactor + " " + expectedUtilities)
      val intervalSelector = Random.nextDouble * scaleFactor

      if (scaleFactor == 0.0) return c.centralVariableValue

      var partialSum: Double = 0.0
      for (action <- expectedUtilities.keys) {
        partialSum += math.exp(expectedUtilities(action) / eta)
        if (intervalSelector <= partialSum) {
          return action
        }
      }
      throw new Exception("This code should be unreachable.")
    }
  }

}

trait EpsilonGreedyDecisionRule extends ArgmaxADecisionRule {
  def epsilon: Double

  override def computeMove(c: State): Action = {
    if (math.random > epsilon) { //Probability 1-epsilon to choose argmax
      super.computeMove(c)
    } else { //probability epsilon to choose randomly
      c.domain.toVector(new Random().nextInt(c.domain.size))
    }
  }

}
