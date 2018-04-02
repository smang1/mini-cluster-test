package com.smang.hadoop.java;

import com.github.sakserv.minicluster.impl.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;

public class SetupConnections {

    public static void setUp() throws Exception {
        ZookeeperLocalCluster zookeeperLocalCluster = new ZookeeperLocalCluster.Builder()
                .setPort(12345)
                .setTempDir("embedded_zookeeper")
                .setZookeeperConnectionString("localhost:12345")
                .setMaxClientCnxns(60)
                .setElectionPort(20001)
                .setQuorumPort(20002)
                .setDeleteDataDirectoryOnClose(false)
                .setServerId(1)
                .setTickTime(2000)
                .build();
        zookeeperLocalCluster.start();

        HdfsLocalCluster hdfsLocalCluster = new HdfsLocalCluster.Builder()
                .setHdfsNamenodePort(8020)
                .setHdfsNamenodeHttpPort(50070)
                .setHdfsTempDir("embedded_hdfs")
                .setHdfsNumDatanodes(1)
                .setHdfsEnablePermissions(false)
                .setHdfsFormat(true)
                .setHdfsEnableRunningUserAsProxyUser(true)
                .setHdfsConfig(new Configuration())
                .build();
        hdfsLocalCluster.start();


        HiveLocalMetaStore hiveLocalMetaStore = new HiveLocalMetaStore.Builder()
                .setHiveMetastoreHostname("localhost")
                .setHiveMetastorePort(9083)
                .setHiveMetastoreDerbyDbDir("metastore_db")
                .setHiveScratchDir("hive_scratch_dir")
                .setHiveWarehouseDir("warehouse_dir")
                .setHiveConf(new HiveConf())
                .build();

        hiveLocalMetaStore.start();

        HiveLocalServer2 hiveLocalServer2 = new HiveLocalServer2.Builder()
                .setHiveServer2Hostname("localhost")
                .setHiveServer2Port(10000)
                .setHiveMetastoreHostname("localhost")
                .setHiveMetastorePort(9083)
                .setHiveMetastoreDerbyDbDir("metastore_db")
                .setHiveScratchDir("hive_scratch_dir")
                .setHiveWarehouseDir("warehouse_dir")
                .setHiveConf(new HiveConf())
                .setZookeeperConnectionString("localhost:12345")
                .build();

        hiveLocalServer2.start();

       HbaseLocalCluster hbaseLocalCluster = new HbaseLocalCluster.Builder()
                .setHbaseMasterPort(25111)
                .setHbaseMasterInfoPort(-1)
                .setNumRegionServers(1)
                .setHbaseRootDir("embedded_hbase")
                .setZookeeperPort(12345)
                .setZookeeperConnectionString("localhost:12345")
                .setZookeeperZnodeParent("/hbase-unsecure")
                .setHbaseWalReplicationEnabled(false)
                .setHbaseConfiguration(new Configuration())
                .activeRestGateway()
                .setHbaseRestHost("localhost")
                .setHbaseRestPort(28000)
                .setHbaseRestReadOnly(false)
                .setHbaseRestThreadMax(100)
                .setHbaseRestThreadMin(2)
                .build()
                .build();

        hbaseLocalCluster.start();

        /*knoxCluster = new KnoxLocalCluster.Builder()
                .setPort(8888)
                .setPath("gateway")
                .setHomeDir("embedded_knox")
                .setCluster("mycluster")
                .setTopology(XMLDoc.newDocument(true)
                        .addRoot("topology")
                        .addTag("gateway")
                        .addTag("provider")
                        .addTag("role").addText("authentication")
                        .addTag("enabled").addText("false")
                        .gotoParent()
                        .addTag("provider")
                        .addTag("role").addText("identity-assertion")
                        .addTag("enabled").addText("false")
                        .gotoParent().gotoParent()
                        .addTag("service")
                        .addTag("role").addText("NAMENODE")
                        .addTag("url").addText("hdfs://localhost:8020")
                        .gotoParent()
                        .addTag("service")
                        .addTag("role").addText("WEBHDFS")
                        .addTag("url").addText("http://localhost:50070/webhdfs")
                        .gotoParent()
                        .addTag("service")
                        .addTag("role").addText("WEBHBASE")
                        .addTag("url").addText("http://localhost:28000")
                        .gotoRoot().toString())
                .build();
        knoxCluster.start();*/
    }

    public static void setupZookeeperConnection() throws Exception {
        ZookeeperLocalCluster zookeeperLocalCluster = new ZookeeperLocalCluster.Builder()
                .setPort(12345)
                .setTempDir("embedded_zookeeper")
                .setZookeeperConnectionString("localhost:12345")
                .setMaxClientCnxns(60)
                .setElectionPort(20001)
                .setQuorumPort(20002)
                .setDeleteDataDirectoryOnClose(false)
                .setServerId(1)
                .setTickTime(2000)
                .build();

        zookeeperLocalCluster.start();

    }

    public static void setupYarnConnection() throws Exception {
        YarnLocalCluster yarnLocalCluster = new YarnLocalCluster.Builder()
                .setNumNodeManagers(1)
                .setNumLocalDirs(1)
                        .setNumLogDirs(1)
                                .setResourceManagerAddress("localhost:37001")
                                .setResourceManagerHostname("localhost")
                                .setResourceManagerSchedulerAddress("localhost:37002")
                                .setResourceManagerResourceTrackerAddress("localhost:37003")
                                .setResourceManagerWebappAddress("localhost:37004")
                                .setUseInJvmContainerExecutor(false)
                                .setConfig(new Configuration())
                                .build();

        yarnLocalCluster.start();
    }

    public static void setupHDFSConnection() throws Exception {
        HdfsLocalCluster hdfsLocalCluster = new HdfsLocalCluster.Builder()
                .setHdfsNamenodePort(8020)
                .setHdfsNamenodeHttpPort(50070)
                .setHdfsTempDir("embedded_hdfs")
                .setHdfsNumDatanodes(1)
                .setHdfsEnablePermissions(false)
                .setHdfsFormat(true)
                .setHdfsEnableRunningUserAsProxyUser(true)
                .setHdfsConfig(new Configuration())
                .build();

        hdfsLocalCluster.start();
    }

    public static void setupHiveConnection() throws Exception {
        HiveLocalServer2 hiveLocalServer2 = new HiveLocalServer2.Builder()
                .setHiveServer2Hostname("localhost")
                .setHiveServer2Port(10000)
                .setHiveMetastoreHostname("localhost")
                .setHiveMetastorePort(9083)
                .setHiveMetastoreDerbyDbDir("metastore_db")
                .setHiveScratchDir("hive_scratch_dir")
                .setHiveWarehouseDir("warehouse_dir")
                .setHiveConf(new HiveConf())
                .setZookeeperConnectionString("localhost:12345")
                .build();

        hiveLocalServer2.start();
    }
}
