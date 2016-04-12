import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class TemperatureMapper extends Mapper<Object, Text, Text, IntWritable>{
	private Text word = new Text();
	
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
		StringTokenizer itr = new StringTokenizer(value.toString(),",");
		
		String weatherStation = itr.nextToken();
		String date =  itr.nextToken();
		String property = itr.nextToken();
		String temperature = itr.nextToken();
		
		if (property.equals("TMAX") || property.equals("TMIN")){
			String month = date.substring(4, 6);
			word.set(month+","+property);
			IntWritable temp = new IntWritable();
			temp.set(Integer.parseInt(temperature));
			context.write(word,temp );
		}
	}
}