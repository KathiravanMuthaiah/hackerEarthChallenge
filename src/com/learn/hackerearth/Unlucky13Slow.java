package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
/**
 * This has OOM error, need to fix this.
 */
public class Unlucky13Slow {

	static long[][] dp;
	public static void main(String[] args) throws Exception {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input1.unlucky13.txt")));
//		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("output1.unlucky13.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer,BigInteger> result = new HashMap<>();
		int n = Integer.valueOf(br.readLine().trim());
		for(int i=0;i<n;i++) {
			int value= Integer.valueOf(br.readLine().trim());
//			int output= Integer.valueOf(br2.readLine().trim());
//			System.out.print(output+" ");
			if(value==0) {
				System.out.println("0");
			}else if(result.containsKey(value)){
				System.out.println(result.get(value));
			}else if(value==1) {
				System.out.println("10");
			}else if(value==2) {
				System.out.println("99");
			}else if(value==3) {
				System.out.println("980");
			}else {
				result.put(value, countValid(value));
				System.out.println();
			}
		}
		
	}
	
	public static BigInteger countValid(int N) {
        // dp[pos][wasOne]: ways to build pos digits where previous digit was 1 or not
        BigInteger[][] dp = new BigInteger[N + 1][2];

        // Base case: 0 digits, not yet placed anything
        dp[0][0] = BigInteger.valueOf(1);

        for (int pos = 0; pos < N; pos++) {
            for (int wasOne = 0; wasOne <= 1; wasOne++) {
                for (int d = 0; d <= 9; d++) {
//                    if (pos == 0 && d == 0) continue; // skip leading zero
                    if (wasOne == 1 && d == 3) continue; // avoid "13"

                    int nextWasOne = (d == 1) ? 1 : 0;
                    dp[pos + 1][nextWasOne].add(dp[pos][wasOne]);
                }
            }
        }

        return dp[N][0].add(dp[N][1]);
    }
	
	
	
	// Count valid numbers of length 'pos' with previous digit 'prevDigit'
    public static long count(int pos, int prevDigit, boolean isTight, boolean isLeadingZero, int N) {
        if (pos == N) return 1;

        int stateIndex = isLeadingZero ? 10 : prevDigit;
        if (!isLeadingZero && dp[pos][stateIndex] != -1) {
            return dp[pos][stateIndex];
        }

        int total = 0;
        for (int d = 0; d <= 9; d++) {
            // skip leading zero
            if (isLeadingZero && d == 0) {
                total += count(pos + 1, 10, true, true, N);
            } else {
                // if previous digit is 1 and current is 3 → invalid
                if (prevDigit == 1 && d == 3) continue;
                total += count(pos + 1, d, false, false, N);
            }
        }

        if (!isLeadingZero) {
            dp[pos][stateIndex] = total;
        }

        return total;
    }

    public static long countValidNumbers(int N) {
        // dp[pos][prevDigit] — prevDigit 0–9, and 10 for 'none'
        dp = new long[N + 1][11];
        for (long[] row : dp) Arrays.fill(row, -1);

        int total = 0;
        for (int d = 1; d <= 9; d++) {
            total += count(1, d, false, false, N);
        }

        return total;
    }
    
}
