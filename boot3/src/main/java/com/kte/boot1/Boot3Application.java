package com.kte.boot1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kte.boot1.WordCount.IntSumReducer;
import com.kte.boot1.WordCount.TokenizerMapper;

@SpringBootApplication
public class Boot3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Boot3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==================== START SPRING BOOT  =======================");

		Configuration conf = new Configuration();
		Job job = new Job(conf, "word count");
		job.setJarByClass(WordCount.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setCombinerClass(IntSumReducer.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		// c:\input폴더에 분석할 text파일을 넣음.
		FileInputFormat.addInputPath(job, new Path("c:/input"));
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd_hh:mm:ss");
		String str = dayTime.format(new Date(time));
		FileOutputFormat.setOutputPath(job, new Path("c:/output_" + time));
		// FileOutputFormat.setOutputPath(job, new Path("c:/"+"output_"+str));
		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}
}
