package com.smang.hadoop.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class MainJob {
    public static void main(String[] args) throws Exception {
        System.setProperty("HADOOP_HOME", "C:\\hadooponwindows-master" );
       SetupConnections.setUp();

        FileSystem hdfs = FileSystem.get(new Configuration());
        Path homeDir=hdfs.getHomeDirectory();
        String testDir = "/C:/Users/Sarath/testDir";
        Path testDirPath = new Path(testDir);
        Path testDirPath1 = new Path("/C:/Users/Sarath/testDir1");
        Path testDirPath2 = new Path("/C:/Users/Sarath/testDir2");
//Print the home directory
        System.out.println("Home folder -" +homeDir);

        System.out.println(hdfs.listFiles(homeDir, true));
        hdfs.mkdirs(testDirPath);
        hdfs.mkdirs(testDirPath1);
        System.out.println(hdfs.exists(testDirPath));
        System.out.println(hdfs.exists(testDirPath1));
        System.out.println(hdfs.exists(testDirPath2));



//
     //   response = Hdfs.mkdir(hadoop).dir("/tmp/example").now();
   /*     SetupConnections.setupZookeeperConnection();
        SetupConnections.setupHDFSConnection();
        SetupConnections.setupHiveConnection();*/

    }
}
