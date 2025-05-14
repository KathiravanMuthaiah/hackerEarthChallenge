package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkAndRotation {

public static void main(String[] args) {
		
//		solve(3,2, new int[] { 2,3,1 });
//		solve(4,2, new int[] { 1, 3, 4, 5 });

		// BufferedReader
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("input5.MonkAndRotation.txt")));
//			br = new BufferedReader(new InputStreamReader(System.in));
			int countTestCase = Integer.valueOf(br.readLine().trim());
			for(int i=0;i<countTestCase;i++) {
				
				String strarr[] = br.readLine().trim().split(" ");
				
				int arrLength = Integer.valueOf(strarr[0]);
				int rotation = Integer.valueOf(strarr[1]);
				String intStrA[] = br.readLine().trim().split(" ");
				int intarrA[] = new int[arrLength];
				for(int j = 0; j < arrLength;j++) {
					intarrA[j] = Integer.valueOf(intStrA[j].trim());
				}
				
				solve(rotation,intarrA);
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	static void solve(int rotation, int[] intarrA ) {
		// Write your code here
		 int len = intarrA.length;
		 	rotation = rotation % len;
		    int[] result = new int[len];
		    StringBuffer sb = new StringBuffer();
		    System.arraycopy(intarrA, len - rotation, result, 0, rotation);
		    System.arraycopy(intarrA, 0, result, rotation, len - rotation);
		    for(int i = 0;i<result.length;i++) {
		    	if(i<result.length-1) {
		    		sb.append(result[i]+" ");
//		    		System.out.print(result[i]+" ");
		    	}else {
		    		sb.append(result[i]);
//		    		System.out.println(result[i]);
		    	}
		    	
		    }
		    System.out.println(sb.toString());
	}
	
	
}
