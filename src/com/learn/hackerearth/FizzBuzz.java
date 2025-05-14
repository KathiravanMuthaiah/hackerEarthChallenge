package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {

	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int countTestCase = Integer.valueOf(br.readLine().trim());
		for(int i=1;i<=countTestCase;i++) {
			
			if(i%15==0) {
				System.out.println("fizzbuzz");
			}else if(i%5==0) {
				System.out.println("buzz");
			}else if(i%3==0) {
				System.out.println("fizz");
			}else {
				System.out.println(i);
			}
			
		}
	}
	
}
