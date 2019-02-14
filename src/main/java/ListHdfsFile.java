import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class ListHdfsFile {
    public static void main(String args[])throws Exception{
        ListAll();
    }
    //显示一组路径下的文件及目录
    public static void ListAll()throws Exception{
        String uri = "hdfs://172.16.173.128:9000/";
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(uri),configuration);
        Path[] paths = new Path[2];
        paths[0] = new Path("hdfs://172.16.173.128:9000/");
        paths[1] = new Path("hdfs://172.16.173.128:9000/HadoopTestText/");
        FileStatus[] fileStatuses = fileSystem.listStatus(paths);
        Path[] listedPaths = FileUtil.stat2Paths(fileStatuses);
        for(Path p:listedPaths){
            System.out.println(p);
        }
    }
}
