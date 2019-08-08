package sparkexam;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class WordCount8 {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("WordCount_version8").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);

		JavaRDD<String> rdd1 = sc.textFile("hdfs://192.168.111.120:9000/edudata/fruit.txt");
	

		JavaRDD<String> rdd2 = rdd1.flatMap(line -> Arrays.asList(line.split("[\\s]+")).iterator());
		
		JavaPairRDD<String, Long> rdd3 = rdd2.mapToPair(w -> new Tuple2<String, Long>(w, 1L));

		JavaPairRDD<String, Long> rdd4 = rdd3.reduceByKey((x, y) -> x + y);
		
		System.out.println(rdd4.collect());
		rdd4.saveAsTextFile("hdfs://192.168.111.120:9000/output/sparkoutput8");
		sc.close();

	}

}
