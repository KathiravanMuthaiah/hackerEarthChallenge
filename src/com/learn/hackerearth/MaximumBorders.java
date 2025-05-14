package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Maximum borders
 * 
 * input
2
2 15
.....####......
.....#.........
7 9
...###...
...###...

output
4
5
 */
public class MaximumBorders {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input0.MaximumBorders.txt")));

		int testCase = Integer.valueOf(br.readLine().trim());

		for (int i = 0; i < testCase; i++) {
			long maxCount = 0;
			String strarr[] = br.readLine().trim().split(" ");
			int rowCount = Integer.valueOf(strarr[0]);
			int dataCount = Integer.valueOf(strarr[1]);
			for (int j = 0; j < rowCount; j++) {
				char data[] = br.readLine().trim().toCharArray();
				long localCount = 0;
				
				for (int k = 0; k < data.length; k++) {
					if (data[k] == '#') {
						if (maxCount <= localCount) {
							maxCount++;
							localCount++;
						} else {
							localCount++;
						}
					}
				}
			}
			System.out.println("" + maxCount);

		}
		br.close();
	}

}
