/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intel.hibench.streambench.common.metrics

object MetricsReader extends App {

  if (args.length < 3) {
    System.err.println("args: <zookeeperConnect> <topic> <outputDir> need to be specified!")
    System.exit(1)
  }

  val zookeeperConnect = args(0)
  val topic = args(1)
  val kafkaConsumer = new KafkaConsumer(zookeeperConnect, topic, 0)

  val outputDir = args(2)
  val latencyCollector = new KafkaCollector(topic, kafkaConsumer, outputDir)
  latencyCollector.start()
}
