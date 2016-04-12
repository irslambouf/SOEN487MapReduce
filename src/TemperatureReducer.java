import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class TemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	private IntWritable result = new IntWritable();
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException{
		String month = key.toString().split(",")[0];
		String property = key.toString().split(",")[1];
		
		if (property.equals("TMIN")){
			int min = 10000; 
			for (IntWritable val : values){
				if (val.get() < min){
					min = val.get();
				}
			}
			
			result.set(min);
		}
		
		if (property.equals("TMAX")){
			int max = -100000;
			for (IntWritable val : values){
				if (val.get() > max){
					max = val.get();
				}
			}
			
			result.set(max);
		}
		
		context.write(key, result);
	}
}
