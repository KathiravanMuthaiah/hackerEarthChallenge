package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/**
 * Number of likes and dislikes
 * input
 * 010101
   101101
   output 
   3
 */
public class LikeDislike {

	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String A = br.readLine();
         String P = br.readLine();

         int out_ = count_like_dislike(A, P);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int count_like_dislike(String A, String P){
       // Write your code here
        int result = 0;
        
        char[] str1arr = A.toCharArray();
        char[] str2arr = P.toCharArray();
        
        for(int i=0;i<A.length();i++) {
        	if(str1arr[i]==str2arr[i]) {
        		result++;
        	}
        }
        
        return result;
    
    }
	
}
