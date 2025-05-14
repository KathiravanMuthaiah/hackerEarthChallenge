package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.Function;

/**
 * 5
 * 1000000001 1000000002 1000000003 1000000004 1000000005
 */
public class ArraySum {

	static Function<String, BigInteger> toBigInt = s -> new BigInteger(s);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine().trim());
		String[] tokens = br.readLine().trim().split(" ");
		BigInteger[] bigIntegers = Arrays.stream(tokens).map(toBigInt).toArray(BigInteger[]::new);
		BigInteger sum = new BigInteger("0");
		for(int i=0;i<n;i++) {
			sum = sum.add(bigIntegers[i]);
		}
		System.out.println(sum.toString());
	}
	
	
}
