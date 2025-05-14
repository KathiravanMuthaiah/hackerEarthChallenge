package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Print Array in Reverse
/**
 *
 *Input
5
4
12
7
15
9
 *output
9
15
7
12
4
 */

public class PrintArrayInReverse {

	public static void main(String args[]) throws Exception {
		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String countString = br.readLine();
		try {
			int count = Integer.valueOf(countString);
			if (count > 0) {
				int intarr[] = new int[count];
				for (int i = 0; i < count; i++) {
					String intStr = br.readLine();
					intarr[i] = Integer.valueOf(intStr).intValue();
				}
				for (int i = count - 1; i >= 0; i--) {
					System.out.println(intarr[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
