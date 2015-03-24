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

/**
 * Target function implementations.
 * Should contain implementations for the functions: updateMemory and computeExpectedUtilities
 */

trait TargetFunction extends Algorithm {

  def computeCandidates(c: State): Set[State] = {
    for {
      assignment <- c.domain
    } yield c.withCentralVariableAssignment(assignment)
  }

  def computeExpectedUtilities(c: State): Map[Action, UtilityType]

  def updateMemory(c: State): State
}

trait MemoryLessTargetFunction extends TargetFunction {

  def computeExpectedUtilityForStateValue(c: State): (Action, UtilityType) = {
    (c.centralVariableValue, computeUtility(c))
  }

  def computeExpectedUtilities(c: State): Map[Action, UtilityType] = {
    val configUtilities = computeCandidates(c).map(c => computeExpectedUtilityForStateValue(c)).toMap
    configUtilities
  }

  override def updateMemory(c: State): State = c
}

/*
 * Used in JSFP-I
 */
trait AverageExpectedUtilityTargetFunction extends MemoryLessTargetFunction with StateWithMemory {

  override def computeExpectedUtilityForStateValue(conf: State): (Action, UtilityType) = {
    val newUtility = if (conf.numberOfCollects == 0) {
      computeUtility(conf)
    } else {
      (computeUtility(conf) + (conf.numberOfCollects - 1) * conf.memory(conf.centralVariableValue)) / conf.numberOfCollects
    }
    (conf.centralVariableValue, newUtility)
  }

  override def updateMemory(c: State): State = {
    val newMemory = computeExpectedUtilities(c)
    c.withUpdatedMemory(newMemory)
  }
}

/*
 * Used in Fading memory JSFP-I
 */
trait WeightedExpectedUtilityTargetFunction extends AverageExpectedUtilityTargetFunction {

  def rho: Double

  override def computeExpectedUtilityForStateValue(conf: State): (Action, UtilityType) = {
    val newUtility = if (conf.numberOfCollects == 0) {
      computeUtility(conf)
    } else {
      rho * computeUtility(conf) + (1 - rho) * conf.memory(conf.centralVariableValue)
    }
    (conf.centralVariableValue, newUtility)
  }

}

/*
 * Used in RM
 */
trait AverageRegretsTargetFunction extends MemoryLessTargetFunction with StateWithMemory {

  def computeExpectedUtilityForStateValue(candidate: State, conf: State): (Action, UtilityType) = {
    val newUtility =  if (conf.numberOfCollects == 0) {
      computeUtility(candidate)
       } else {
        (computeUtility(candidate) - computeUtility(conf) + (conf.numberOfCollects - 1) * conf.memory(conf.centralVariableValue)) / conf.numberOfCollects
      }
    (candidate.centralVariableValue, newUtility)
  }


  //takes max out of the 0 and expectedUtility
  override def computeExpectedUtilities(conf: State) = {
    val configUtilities = computeCandidates(conf).map(c => {
      val (value, utility) = computeExpectedUtilityForStateValue(c, conf)
      (value, math.max(0, utility))
    }).toMap

    configUtilities
  }

  override def updateMemory(conf: State): State = {
    val newMemory = //computeExpectedUtilities(c)
      computeCandidates(conf).map(c => computeExpectedUtilityForStateValue(c, conf)).toMap
    conf.withUpdatedMemory(newMemory)
  }

}

/*
 * Used in WRM-I
 */
trait DiscountedAverageRegretsTargetFunction extends AverageRegretsTargetFunction {

  def rho: Double

  /*
   * All regrets are minimum 0.
   */
  override def computeExpectedUtilityForStateValue(candidate: State, conf: State): (Action, UtilityType) = {
    val newUtility = rho * (computeUtility(candidate) - computeUtility(conf)) + (1 - rho) * candidate.memory(candidate.centralVariableValue)
    (candidate.centralVariableValue, newUtility)
  }

//  def updateMemory(conf: State): State = {
//    val newMemory = computeCandidates(conf).map(c =>
//      (c.centralVariableValue, rho * (computeUtility(c) - computeUtility(conf)) + (1 - rho) * c.memory(c.centralVariableValue))).toMap
//    conf.withUpdatedMemory(newMemory)
//  }

}

