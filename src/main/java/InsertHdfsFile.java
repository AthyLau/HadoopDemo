import org.apache.hadoop.conf.Configuration;


import java.io.*;
import java.net.URI;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;


public class InsertHdfsFile {

    public static void main(String args[])throws IOException{
        insertData_1();
    }
    public static void insertData_1()throws IOException {
        System.out.println("insertData_1");
        //定义uri
        String uri_local = "/Users/lcxy_demo/Documents/hadoopTest/password.txt";
        String uri_hdfs = "hdfs://172.16.173.128:9000/HadoopTestText/password.txt";
        //利用javaIo流将文件读入到输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(uri_local));
        //配置文件
        Configuration configuration = new Configuration();
        //打开一个文件的流输入
        FileSystem fileSystem = FileSystem.get(URI.create(uri_hdfs),configuration);
        //流与hdfs连接上
        OutputStream outputStream = fileSystem.create(new Path(uri_hdfs), new Progressable() {
            @Override
            public void progress() {
                System.out.println(".");
            }
        });
        IOUtils.copyBytes(bufferedInputStream,outputStream,4096,false);
    }
    public static void insertData_2(){

    }
    public static void insertData_3(){

    }
}
