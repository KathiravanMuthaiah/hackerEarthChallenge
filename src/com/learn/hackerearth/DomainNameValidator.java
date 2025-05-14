package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2
 * ww.gf.df.gff.s
 * ww1.daf.aa
 */
public class DomainNameValidator {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		String fqdnRegex = "^(?=.{1,253}$)(?:(?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,63}\\.?$";

		for(int i=0;i<n;i++) {
			String domainstr = br.readLine().trim();
			sb.append(domainstr.matches(fqdnRegex)+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
