package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * I have not verified this, need to verify it again.
 * https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/average-subarray-7b376ebf/
 */
public class FindingTheSubArrayLargeAverageSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("288905387ba111ed.TramRide.txt")));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.valueOf(br.readLine().trim());

		int[] intarr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = intarr.length;
		int total = 1 << N;
		Set<String> seen = new HashSet<>();
		List<List<Integer>> winnerList = new ArrayList<>();

		for (int mask = 0; mask < total; mask++) {
			List<Integer> A1 = new ArrayList<>();
			List<Integer> A2 = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				if (((mask >> i) & 1) == 1) {
					A1.add(intarr[i]);
				} else {
					A2.add(intarr[i]);
				}
			}

			// skip both sides empty
			if (A1.isEmpty() && A2.isEmpty())
				continue;
			
			List<Integer> originalA = Arrays.stream(intarr)
                    .boxed()
                    .collect(Collectors.toList());
			// Deduplicate (A1, A2) vs (A2, A1)
			List<Integer> sortedA1 = new ArrayList<>(A1);
			List<Integer> sortedA2 = new ArrayList<>(A2);
			Collections.sort(sortedA1);
			Collections.sort(sortedA2);
			String key = sortedA1.toString() + "#" + sortedA2.toString();
			String revKey = sortedA2.toString() + "#" + sortedA1.toString();
			if (seen.contains(key) || seen.contains(revKey))
				continue;
			seen.add(key);

			double avg1 = A1.isEmpty() ? 0 : A1.stream().mapToDouble(i -> i).average().orElse(0);
			double avg2 = A2.isEmpty() ? 0 : A2.stream().mapToDouble(i -> i).average().orElse(0);

			if (avg1 != avg2) {
				List<Integer> winner = avg1 > avg2 ? A1 : A2;
				StringBuilder builder = new StringBuilder("");
				winner.forEach(x->{
					builder.append(originalA.indexOf(x.intValue())).append(" ");
				});
				
				winnerList.add(new ArrayList<>(winner));
				wr.println(builder);
			}
			
		}
		wr.close();
		br.close();
	}

}
