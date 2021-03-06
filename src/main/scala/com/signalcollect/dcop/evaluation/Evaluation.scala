/*
 *  @author Philip Stutz
 *  @author Mihaela Verman
 *  
 *  Copyright 2013 University of Zurich
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

package com.signalcollect.dcop.evaluation

import com.signalcollect.nodeprovisioning.slurm._
import com.signalcollect.nodeprovisioning.ExecutionHost
import com.signalcollect.nodeprovisioning.Job

case class Evaluation(
  evaluationName: String,
  evaluationNumber: Int = 0,
  executionHost: ExecutionHost = new LocalHost,
  evaluationRuns: List[() => List[Map[String, String]]] = List(),
  resultHandlers: List[Map[String, String] => Unit] = List(println(_)),
  numberOfNodes: Int = 1,
  extraStats: Map[String, String] = Map()) {
  def addEvaluationRun(evaluationRun: () => List[Map[String, String]]) = Evaluation(evaluationName, evaluationNumber, executionHost, evaluationRun :: evaluationRuns, resultHandlers, numberOfNodes, extraStats)
  def addResultHandler(resultHandler: Map[String, String] => Unit) = Evaluation(evaluationName, evaluationNumber, executionHost, evaluationRuns, resultHandler :: resultHandlers, numberOfNodes, extraStats)
  def addExtraStats(stats: Map[String, String]) = Evaluation(evaluationName, evaluationNumber, executionHost, evaluationRuns, resultHandlers, numberOfNodes, extraStats ++ stats)
  def execute {

    val jobs = (evaluationRuns zip (1 to evaluationRuns.size)) map { runTuple =>
      val evaluationRun = runTuple._1
      val jobNumber = runTuple._2
      val jobId = jobNumber * 100 + evaluationNumber % 100
      val jobFunction = () => {
        println(s"Job $jobId is being executed ...")
        val stats = evaluationRun() // Execute evaluation.
        for (stat <- stats) {
          resultHandlers foreach (handler => handler(stat ++ extraStats ++ Map("jobId" -> jobId.toString)))
        }
        println("Done.")
      }

      //    val jobs = evaluationRuns map { evaluationRun =>
      //      val jobId = Random.nextInt.abs % 10000000
      //      val jobFunction = () => {
      //        println(s"Job $jobId is being executed ...")
      //        val stats = evaluationRun() // Execute evaluation.
      //        for (stat <- stats) {
      //          resultHandlers foreach (handler => handler(stat ++ extraStats ++ Map("jobId" -> jobId.toString)))
      //        }
      //        println("Done.")
      //      }
      Job(jobFunction, jobId.toString, numberOfNodes)
    }
    executionHost.executeJobs(jobs)
  }
}