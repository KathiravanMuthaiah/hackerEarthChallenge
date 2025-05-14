package com.learn.hackerearth;
/**
 * 
 * Time limit is still there need to fix that.
 * 
 * 	Problem
Given a string S consisting of lower case English alphabets and an integer K.

You need to form a new string P that follows the following conditions:

Length of P should be equal to K + length of string S.
P should only be formed by using the prefixes of string S.
P should be lexicographically smallest.
Task

Determine the string P that satisfies all the given conditions.

Example

Assumptions

N = 3
K = 4
S = bca
Approach

Prefixes of S are "b", "bc", "bca".
String P will be "bbbbbbb" of length 7 (N + K i.e. 3 + 4).
Function Description

Complete the solve function provided in the editor. This function takes the following 3 parameters and returns the valid string:

N: Represents the size of string S.
K: Represents the given integer.
S: Represents the given string.
Input Format

Note: This is the input format you must use to provide custom input (available above the Compile and Test button).

The first line contains a single integer T denoting the number of test cases.
For each test case:
The first line contains a single integer N denoting the size of string S.
The second line contains a single integer K denoting the number of new characters added in string S.
The third line contains the string S.
Output Format

For each test case in a separate line, output a string P that satisfies all the given conditions.
input
2
6
4
cbacaa
2
2
aa

output
cbacaacbac
aaaa

 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class StringChallenge {

	
	public static void main(String[] args)  throws Exception{
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input1.StringChallenge.txt")));
      int t = Integer.parseInt(br.readLine().trim());
      for(int testCount=0;testCount<t;testCount++) {
    	  int n = Integer.valueOf(br.readLine().trim());
    	  int k = Integer.valueOf(br.readLine().trim());
    	  String S = br.readLine().trim();
    	  
    	  int total = n+k;
    	  
    	  String best = null;

    	  for (int i = 1; i <= n; i++) {
    	      String prefix = S.substring(0, i);

    	      StringBuilder sb = new StringBuilder();
    	      while (sb.length() < total) sb.append(prefix);
    	      String candidate = sb.substring(0, total);

    	      if (best == null || candidate.compareTo(best) < 0) {
    	          best = candidate;
    	      } 
    	  }
    	  
    	  System.out.println(best);
      }
	}
	
}
