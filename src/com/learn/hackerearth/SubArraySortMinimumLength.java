package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * Not solved, need to revisit this.
 * Minimum Length
 * Problem
You are given two arrays 
 and 
, of length 
. You can select any subarray and then sort the elements in ascending order of that subarray for arrays 
 and 
.

Find the minimum length of the subarray you can choose to make 
 and 
 same after performing the operation. 
 and 
 are permutations of each other.

Input Format:

The first line contains an integer 
 denoting the number of test cases.
The first line of each test case contains an integer 
.
The next line of each test case contains 
 space-separated integers, elements of array 
.
The next line of each test case contains 
 space-separated integers, elements of array 
.
Output Format:

For each test case, print the minimum length of the subarray you can choose to make 
 A and B 
 same after performing the operation.
 
 
Input
2
3
2 3 1 
2 1 3
4
1 1 2 1
2 1 1 1

Output
2
3

Explanation
First test case:
We can choose a subarray from index 
 2to3 
 (1-based indexing). Hence, the answer is 2
.

Second test case:
We can choose a subarray from index 
 1to3 
 (1-based indexing). Hence, the answer is 3
.


 */
public class SubArraySortMinimumLength {
	
	public static void main(String[] args) {
		
//		System.out.println(solve(3, new int[] { 2,3,1 }, new int[] {2,1,3}));
//		System.out.println(solve(4, new int[] { 1, 1, 2, 1 }, new int[] {2,1,1,1}));

		// BufferedReader
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("input7.SubArraySortMinimumLength.txt")));
//			br = new BufferedReader(new InputStreamReader(System.in));
			int countTestCase = Integer.valueOf(br.readLine().trim());
//			System.out.println("countTestCase : "+countTestCase);
			for(int i=0;i<countTestCase;i++) {
				
				int arrLength = Integer.valueOf(br.readLine().trim());
//				System.out.println("arrLength : "+arrLength);
				String intStrA[] = br.readLine().trim().split(" ");
				String intStrB[] = br.readLine().trim().split(" ");
				int intarrA[] = new int[arrLength];
				int intarrB[] = new int[arrLength];
				for(int j = 0; j < arrLength;j++) {
					intarrA[j] = Integer.valueOf(intStrA[j].trim());
					intarrB[j] = Integer.valueOf(intStrB[j].trim());
				}
				
				System.out.println(solve(arrLength,intarrA,intarrB));
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	static long solve(int n, int[] intarrA, int[] intarrB) {
		// Write your code here
		int minimumArraySize = intarrA.length;
		for (int i = 0; i < n; i++) {
			for(int j=i+2;j<=n;j++) {
				
				int intarrAsub[] =  new int[j-i];
				int intarrBsub[] =  new int[j-i];
				
				System.arraycopy(intarrA, i, intarrAsub, 0, j - i);
				System.arraycopy(intarrB, i, intarrBsub, 0, j - i);
				
				Arrays.sort(intarrAsub);
				Arrays.sort(intarrBsub);
				if(Arrays.equals(intarrAsub, intarrBsub)) {
					if(minimumArraySize > intarrAsub.length) {
						minimumArraySize = intarrAsub.length;
						if(minimumArraySize == 2) return 2;
					}
				}
			}
		}
		return minimumArraySize;
	}
}
