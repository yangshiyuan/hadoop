package ysy.hadoop.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Test4 {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:9000");

        conf.set("mapreduce.job.jar", "target/hdfs-1.0-SNAPSHOT.jar");
        conf.set("mapreduce.framework.name", "yarn");
        conf.set("yarn.resourcemanager.hostname", "yarn");
        conf.set("mapreduce.app-submission.cross-platform", "true");

        Job job = Job.getInstance(conf);

        job.setMapperClass(WordMapper.class);
        job.setReducerClass(WordReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, "/wcinput");
        FileOutputFormat.setOutputPath(job, new Path("/wcoutput2"));

        job.waitForCompletion(true);
    }
}
