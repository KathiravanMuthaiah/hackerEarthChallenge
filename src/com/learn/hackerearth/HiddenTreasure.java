package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Explanation
Given

N = 4, nums = [51, 71, 17, 42]

Approach:

51 → Sum of digits = 6
71 → Sum of digits = 8
17 → Sum of digits = 8
42 → Sum of digits = 6
Valid pairs:

(1,4) → 51 & 42 (sum = 6)
(2,3) → 71 & 17 (sum = 8)
Total = 2
 */

public class HiddenTreasure {

	public static void main(String[] args) {
		long result = solve(7, new int[] { 51, 71, 17, 42, 33, 24, 15 });
		System.out.println(result);

		// BufferedReader
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("7a18f2cdf54211ef.HiddenTreasure.txt")));
			String countString = br.readLine().trim();
			int n = Integer.valueOf(countString);
			int intarr[] = new int[n];
			String intStr[] = br.readLine().trim().split(" ");
			for(int i = 0; i < intStr.length;i++) {
				intarr[i] = Integer.valueOf(intStr[i].trim());
			}
			System.out.println(solve(n, intarr));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	static long solve(int n, int[] nums) {
		// Write your code here
		long result[] = { 0 };
		HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			String s = "" + nums[i];
			
			Integer sum = 0;
			for(int j=0;j<s.length();j++) {
				sum += Character.getNumericValue(s.charAt(j));
			}
			if (resultMap.keySet().contains(Integer.valueOf(sum))) {
				int sumCount = resultMap.get(sum).intValue() + 1;
				resultMap.put(sum, sumCount);
			} else {
				resultMap.put(sum, 1);
			}
		}
		resultMap.forEach((k, v) -> {
//	        	System.out.println(k+":("+v+")");
//	        	System.out.println(k+":"+(v*(v-1))/2);
			result[0] += ((v * (v - 1)) / 2);
		});

		return result[0];
	}

}
