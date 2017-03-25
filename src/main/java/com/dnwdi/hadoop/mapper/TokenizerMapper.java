package com.dnwdi.hadoop.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by max on 26/03/2017.
 */
public class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable>{
    private final static IntWritable ONE = new IntWritable(1);
    private Text word = new Text();

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        StringTokenizer st = new StringTokenizer(value.toString());
        while (st.hasMoreTokens()){
            word.set(st.nextToken());
            context.write(word, ONE);
        }
    }
}
