package com.learn.hackerearth;
/**
 * 
 * 	1
	andadds
	d
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountInString {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String s = br.readLine().trim();
			char k = br.readLine().trim().charAt(0);
			char[] schar = s.toCharArray();
			int count =0;
			for(int j=0;j<schar.length;j++) {
				if(k==schar[j]) {
					count++;
				}
			}
			sb.append(count+"\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
}
