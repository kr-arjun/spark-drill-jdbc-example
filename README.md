# spark-drill-jdbc-example

A sample program to connect Drill using Spark JDBC.

## Getting Started

Clone the directory and change connection url and user details as per your environment.
```
git clone git@github.com:kr-arjun/spark-drill-jdbc-example.git
cd spark-drill-jdbc-example/
mvn clean install
```
## Usage

1) Copy drill-jdbc-all jar and maven built jar to cluster node.
2) Execute the sample program as given below.

```
export DRILL_JDBC_DRIVER=drill-jdbc-all-1.11.0.jar
/opt/mapr/spark/spark-2.1.0/bin/spark-submit --class SparkDrillJdbcTest \
--conf spark.driver.extraClassPath=${DRILL_JDBC_DRIVER} --master local[*] spark-drill-jdbc-test-1.0-SNAPSHOT.jar
```
You should see output like (logs are truncated):

```
[mapr@mapr-lab-node1 ~]$ export DRILL_JDBC_DRIVER=drill-jdbc-all-1.11.0.jar;/opt/mapr/spark/spark-2.1.0/bin/spark-submit --class SparkDrillJdbcTest --conf spark.driver.extraClassPath=${DRILL_JDBC_DRIVER} --master local[*] spark-drill-jdbc-test-1.0-SNAPSHOT.jar

18/01/25 16:59:08 INFO Executor: Finished task 0.0 in stage 0.0 (TID 0). 1488 bytes result sent to driver
18/01/25 16:59:08 INFO TaskSetManager: Finished task 0.0 in stage 0.0 (TID 0) in 13545 ms on localhost (executor driver) (1/1)
18/01/25 16:59:08 INFO TaskSchedulerImpl: Removed TaskSet 0.0, whose tasks have all completed, from pool
18/01/25 16:59:08 INFO DAGScheduler: ResultStage 0 (show at DrillJDBCTest.scala:46) finished in 13.759 s
18/01/25 16:59:08 INFO DAGScheduler: Job 0 finished: show at DrillJDBCTest.scala:46, took 15.744735 s
18/01/25 16:59:08 INFO CodeGenerator: Code generated in 121.05824 ms
+-------+--------------------+
|version|           commit_id|
+-------+--------------------+
| 1.10.0|3fb89f898360cbbc3...|
+-------+--------------------+
18/01/25 16:59:08 INFO SparkContext: Invoking stop() from shutdown hook
18/01/25 16:59:09 INFO SparkUI: Stopped Spark web UI at http://mapr-lab-node1:4040
18/01/25 16:59:09 INFO MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
18/01/25 16:59:09 INFO MemoryStore: MemoryStore cleared
18/01/25 16:59:09 INFO BlockManager: BlockManager stopped
18/01/25 16:59:09 INFO BlockManagerMaster: BlockManagerMaster stopped
18/01/25 16:59:09 INFO OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
18/01/25 16:59:09 INFO SparkContext: Successfully stopped SparkContext
18/01/25 16:59:09 INFO ShutdownHookManager: Shutdown hook called
18/01/25 16:59:09 INFO ShutdownHookManager: Deleting directory /tmp/spark-12c3ede7-d50a-45c6-802a-901b9040deb5
[mapr@mapr-lab-node1 ~]$
```
