import org.apache.directory.shared.kerberos.codec.adKdcIssued.actions.StoreIRealm;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/***
 *
 * 从 Hadoop Hdfs 读取数据
 *
 */
public class CatHdfsFile {
    static{
        //开启hdfs协议
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }
    public static void main(String []args) throws Exception{
        System.out.println("ReadData_1()=================================================");
        ReadData_1();
        System.out.println("ReadData_2()=================================================");
        ReadData_2();
        System.out.println("ReadData_3()=================================================");
        ReadData_3();
    }


    //通过 url 从 Hadoop Hdfs 读取数据
    public static void ReadData_1() throws Exception{
        //需要开启hdfs协议
        InputStream inputStream = null;
        try{
            inputStream = new URL("hdfs://172.16.173.128:9000/HadoopTestText/passwd").openStream();
            IOUtils.copyBytes(inputStream,System.out,4096,false);
        }finally {
            IOUtils.closeStream(inputStream);
        }
    }
    //通过 FileSystem API 读取数据
    public static void ReadData_2() throws Exception{
        String uri="hdfs://liubing:9000/HadoopTestText/passwd";
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),configuration);
        InputStream inputStream = null;
        try{
            inputStream = fs.open(new Path(uri));
            IOUtils.copyBytes(inputStream,System.out,4096,false);
        }finally {
            IOUtils.closeStream(inputStream);
        }
    }
    public static void ReadData_3() throws Exception{
        String uri="hdfs://liubing:9000/HadoopTestText/password.txt";
        //Configuration 对象封装了服务器或者是客户端的配置属性
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(uri),configuration);
        FSDataInputStream fsDataInputStream = null;
        try{
            fsDataInputStream = fileSystem.open(new Path(uri));
            //读到控制台
            IOUtils.copyBytes(fsDataInputStream,System.out,4096,false);
            //定位到第一个字符
            fsDataInputStream.seek(0);
            //读到控制台
            IOUtils.copyBytes(fsDataInputStream,System.out,4096,false);
        }finally {
            //关闭
            IOUtils.closeStream(fsDataInputStream);
        }

    }
}


