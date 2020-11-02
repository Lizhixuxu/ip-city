package com.lz.consumer;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBufferStream{
	public static void main(String[] args){
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\21288\\Desktop\\ip.txt"), "gbk"));
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\21288\\Desktop\\data.txt"));
			String s = null;
			while((s = in.readLine()) != null){
				s.replaceAll(" +", " ");
				Pattern p = Pattern.compile("\\s+");
				Matcher m = p.matcher(s);
				s = m.replaceAll(" ");
				out.write(s);
				out.newLine();
			}
			out.flush();
			in.close();
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}