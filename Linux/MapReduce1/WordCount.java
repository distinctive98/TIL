package exercise1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

																																																																

public class WordCount {
	  public static void main(String[] args) throws Exception {
	    Configuration conf = new Configuration();
	    conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
	   
	    Job job = Job.getInstance(conf);

	    job.setJarByClass(WordCount.class);
	    job.setMapperClass(WordCountMapper.class);
	    job.setReducerClass(WordCountReducer.class);

	    job.setInputFormatClass(TextInputFormat.class);
	    job.setOutputFormatClass(TextOutputFormat.class);

	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);

	    FileInputFormat.addInputPath(job, new Path("/edudata/fruit.txt"));
	    FileOutputFormat.setOutputPath(job, new Path("/output/exer_out1"));

	    job.waitForCompletion(true);
	  }
	}

