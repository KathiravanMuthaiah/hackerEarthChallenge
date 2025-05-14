package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
/**
 * This has some output as explained in the video, but seems to be wrong output. Formula is not correct.
 * 
 */
public class Unlucky13Fast {

	static int mod = 1000000009;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input1.unlucky13.txt")));
//		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("output1.unlucky13.txt")));
		int t = Integer.parseInt(br.readLine().trim());
		HashMap<Integer,BigInteger> result = new HashMap<>();
		for (int i = 0; i < t; i++) {
			int input = Integer.parseInt(br.readLine().trim());
//			int output = Integer.parseInt(br2.readLine().trim());
			result.put(input, BigInteger.valueOf(computeNot13Count(input, result)));
//			System.out.print(output+" ");
			System.out.println(result.get(input));
		}
	}

	public static long computeNot13Count(int input, HashMap<Integer,BigInteger> result) {
		long localResult = 0;
		if (result.containsKey(input)) {
			localResult = result.get(input).longValue();
		}else {
			localResult = 
			switch (input) {
			case 0: {
				yield 1l;
			}
			case 1: {
				yield 10l;
			}
			case 2: {
				yield 99l;
			}
			case 3: {
				yield 980l;
			}
			default: {
				

				long t1 = computeNot13Count(input / 2, result);
				long t2 = computeNot13Count(input / 2 - 1, result);
				
				if (input % 2 == 0) {
					localResult = (t1 * t1 - t2 * t2) % mod;
				} else {
					long t3 = computeNot13Count(input / 2 + 1, result);
					localResult = (t1*(t3-t2))%mod;
				}

				yield localResult;
			}
			};
			
			result.put(input, BigInteger.valueOf(localResult));
		}
		
		return localResult;
	}
}
