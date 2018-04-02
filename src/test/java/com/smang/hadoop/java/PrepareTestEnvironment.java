package com.smang.hadoop.java;
public class PrepareTestEnvironment {}

/*


import com.github.sakserv.minicluster.impl.HbaseLocalCluster;
import com.github.sakserv.minicluster.impl.HdfsLocalCluster;
import com.github.sakserv.minicluster.impl.KnoxLocalCluster;
import com.github.sakserv.minicluster.impl.ZookeeperLocalCluster;
import com.mycila.xmltool.XMLDoc;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.gateway.shell.BasicResponse;
import org.apache.hadoop.gateway.shell.Hadoop;
import org.apache.hadoop.gateway.shell.hbase.HBase;
import org.apache.hadoop.gateway.shell.hdfs.Hdfs;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

@Ignore
public class PrepareTestEnvironment {

    private static HbaseLocalCluster hbaseLocalCluster;
    private static ZookeeperLocalCluster zookeeperLocalCluster;
    private static HdfsLocalCluster hdfsLocalCluster;
    private static KnoxLocalCluster knoxCluster;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("HADOOP_HOME", "C:\\hadooponwindows-master" );
        zookeeperLocalCluster = new ZookeeperLocalCluster.Builder()
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

        hdfsLocalCluster = new HdfsLocalCluster.Builder()
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

        hbaseLocalCluster = new HbaseLocalCluster.Builder()
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

        */
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
        knoxCluster.start();*//*

    }
@Test
    public void testMinicluster() throws InterruptedException, URISyntaxException {
        Hadoop hadoop = Hadoop.loginInsecure("https://localhost:8888/gateway/mycluster", "", "");

        BasicResponse response = null;

// HDFS
    response = Hdfs.mkdir(hadoop).dir("/tmp/example").now();
    System.out.println(response);
       */
/* try {
            response = Hdfs.mkdir(hadoop).dir("/tmp/example").now();
        } finally {
            close("hdfs mkdir", response);
        }*//*

       */
/* try {
            response = Hdfs.put(hadoop).file(".../my-file").to("/tmp/example/my-file").now();
        } finally {
            close("hdfs put", response);
        }

// HBase
        try {
            response = HBase.session(hadoop).table("my_table").create()
                    .family("family1").endFamilyDef()
                    .family("family2").endFamilyDef()
                    .now();
        } finally {
            close("hbase create", response);
        }
        try {
            response = HBase.session(hadoop).table("my_table").row("row_id_1").store()
                    .column("family1", "col1", "col_value1")
                    .column("family1", "col2", "col_value2", 1234567890l)
                    .column("family2", null, "fam_value1")
                    .now();
        } finally {
            close("hbase put", response);
        }*//*


        hadoop.shutdown(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        hbaseLocalCluster.stop();
        zookeeperLocalCluster.stop();
        hdfsLocalCluster.stop();
        knoxCluster.stop();
    }
}
*/
