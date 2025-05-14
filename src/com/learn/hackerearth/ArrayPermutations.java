package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
/**
 * Not working in progress.
 */
public class ArrayPermutations {

	public static void main(String[] args) throws IOException {


//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("288905387ba111ed.TramRide.txt")));
		PrintWriter wr = new PrintWriter(System.out);
		String strarr[] = br.readLine().trim().split(" ");
		int n = Integer.valueOf(strarr[0]);
		int testCase = Integer.valueOf(strarr[1]);
		
		int[] intarr = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
		
		
		// Precompute prefix and suffix maximums
        int[] prefixMax = new int[n + 1];
        int[] suffixMax = new int[n + 2];
 
        prefixMax[0] = Integer.MIN_VALUE;
        suffixMax[n + 1] = Integer.MIN_VALUE;
 
        for (int i = 1; i <= n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], intarr[i - 1]);
        }
 
        for (int i = n; i >= 1; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], intarr[i - 1]);
        }
 
        // Read queries and process them
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            String[] query = br.readLine().split(" ");
            int l = Integer.parseInt(query[0]);
            int r = Integer.parseInt(query[1]);
 
            // Find the max outside the range [l, r]
            int maxOutside = Math.max(prefixMax[l - 1], suffixMax[r + 1]);
            output.append(maxOutside).append("\n");
        }

		wr.println(output);

		wr.close();
		br.close();
	}

}
