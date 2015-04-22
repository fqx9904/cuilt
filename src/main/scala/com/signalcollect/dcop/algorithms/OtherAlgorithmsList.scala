
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

/*
 * File automatically generated with "AlgorithmsGenerator"
 */

package com.signalcollect.dcop.algorithms

import com.signalcollect.dcop.graph._
import com.signalcollect.dcop.modules._
import com.signalcollect.dcop.algorithms._
import com.signalcollect.dcop.evaluation._
import com.signalcollect._
import com.signalcollect.configuration.ExecutionMode

object RemainingAlgorithmList {
  val algorithmsSync = List(
    new AverageExpectedUtilityTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2),
    new AverageExpectedUtilityTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.6),
    new AverageExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.001),
    new AverageExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.6),
    new AverageExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.2),
    new AverageRegretsTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2),
    new AverageRegretsTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8),
    new AverageRegretsTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.4),
    new AverageRegretsTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.6),
    new AverageRegretsTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.1),
    new AverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.8),
    new AverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.6),
    new DiscountedAverageRegretsTargetFunction_ArgmaxADecisionRule_FloodAdjustmentSchedule(parrho = 0.6),
    new DiscountedAverageRegretsTargetFunction_ArgmaxADecisionRule_FloodAdjustmentSchedule(parrho = 0.8),
    new DiscountedAverageRegretsTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2, parrho = 0.2),
    new DiscountedAverageRegretsTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.4, parrho = 0.6),
    new DiscountedAverageRegretsTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8, parrho = 0.2),
    new DiscountedAverageRegretsTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8, parrho = 0.4),
    new DiscountedAverageRegretsTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8, parrho = 0.6),
    new DiscountedAverageRegretsTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2, parrho = 0.8),
    new DiscountedAverageRegretsTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.4, parrho = 0.4),
    new DiscountedAverageRegretsTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.6, parrho = 0.4),
    new DiscountedAverageRegretsTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8, parrho = 0.2),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.001, parrho = 0.8),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.2, parrho = 0.4),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.2, parrho = 0.8),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.6, parrho = 0.4),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.6, parrho = 0.8),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.2, parrho = 0.2),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.4, parrho = 0.2),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.4, parrho = 0.4),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.6, parrho = 0.4),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.6, parrho = 0.8),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.2, parrho = 0.6),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.4, parrho = 0.4),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.4, parrho = 0.6),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.6, parrho = 0.2),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.8, parrho = 0.2),
    new DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.8, parrho = 0.4),
    new MemoryLessTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2),
    new MemoryLessTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.4),
    new WeightedExpectedUtilityTargetFunction_ArgmaxADecisionRule_FloodAdjustmentSchedule(parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_ArgmaxADecisionRule_FloodAdjustmentSchedule(parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.4, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.6, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.6, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_ArgmaxADecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_FloodAdjustmentSchedule(parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_FloodAdjustmentSchedule(parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_FloodAdjustmentSchedule(parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_FloodAdjustmentSchedule(parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.2, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.4, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.4, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.4, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.6, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.6, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.6, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.6, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(parchangeProbability = 0.8, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.001, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.001, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.001, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.01, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.01, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.01, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.01, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.1, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.1, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(parepsilon = 0.1, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.2, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.4, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.4, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.4, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.6, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.001, parchangeProbability = 0.8, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.2, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.2, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.2, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.4, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.4, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.6, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.01, parchangeProbability = 0.8, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.2, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.2, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.4, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.4, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.6, parrho = 0.2),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.6, parrho = 0.6),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.6, parrho = 0.8),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.8, parrho = 0.4),
    new WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(parepsilon = 0.1, parchangeProbability = 0.8, parrho = 0.8))

//   val algorithmsAsync = List(
//   new  AverageExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(epsilon0.01,changeProbability0.95 ),
//new   DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(epsilon0.001,rho0.6  ),
//new   DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(epsilon0.001,rho0.8  ),
//new   DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(epsilon0.1,rho0.6  ),
//new   DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(epsilon0.001,changeProbability0.95,rho0.8  ),
//new   DiscountedAverageRegretsTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(epsilon0.1,changeProbability0.95,rho0.2  ),
//new   MemoryLessTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(epsilon0.01,changeProbability0.95 ),
//new   WeightedExpectedUtilityTargetFunction_ArgmaxBDecisionRule_ParallelRandomAdjustmentSchedule(changeProbability0.95,rho0.4 ),
//new   WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(epsilon0.001,rho0.6 ),
//new   WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(epsilon0.1,rho0.2 ),
//new   WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_FloodAdjustmentSchedule(epsilon0.1,rho0.4 ),
//new   WeightedExpectedUtilityTargetFunction_EpsilonGreedyDecisionRule_ParallelRandomAdjustmentSchedule(epsilon0.1,changeProbability,0.95,rho0.4 )    
//   ) 
    
}