import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

public class MaxTemperatureMapper extends MapReduceBase implements Mapper<LongWritable,PolicyUtils.Text,Text,IntWritable>{


    @Override
    public void map(LongWritable longWritable, PolicyUtils.Text text, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {

    }
}
