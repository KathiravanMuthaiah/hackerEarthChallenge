package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem Bob has a playlist of N songs, each song has a singer associated with
 * it (denoted by an integer)
 * 
 * Favourite singer of Bob is the one whose songs are the most on the playlist
 * 
 * Count the number of Favourite Singers of Bob
 * 
 * Input Format
 * 
 * The first line contains an integer N, denoting the number of songs in Bob's
 * playlist.
 * 
 * The following input contains N integers, i t h integer denoting the singer of
 * the i t h song.
 * 
 * Output Format
 * 
 * Output a single integer, the number of favourite singers of Bob
 * 
 * Note: Use 64 bit data type
 * 
 * Constraints
 * 
 * input 5 1 1 2 2 4
 * 
 * output 2
 */
public class FavouriteSinger {

	public static void main(String args[] ) throws Exception {
	        //BufferedReader
//	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("11be3d24f00811ed.FavouriteSinger.txt")));
	        int count = Integer.parseInt(br.readLine().trim());                // Reading input from STDIN
	        if(count ==0) {
	        	System.out.println(0);
	        }
	        else {
	        	long longarr[] = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
	 	        HashMap<Long,Integer> maxMap = new HashMap<>();
	 	        int maxCount[] =new int[] {1};
	 	        int maxID[] =new int[] {0};
	 	        
	 	       if(count==1) {
		        	System.out.println(1);
		        }else if(count<3) {
		        	if(longarr[0]==longarr[1]) {
		        		System.out.println(1);
		        	}else {
		        		System.out.println(2);
		        	}
		        }else {
	        	for(int i=0;i<longarr.length;i++){
//		        	int id=0;
		        	int idCount=0;
		        	if(maxMap.containsKey(longarr[i])){
		        		idCount = maxMap.get(longarr[i])+1;
		        		maxMap.put(longarr[i], idCount);
		        		if(maxCount[0]<idCount) {
		        			maxCount[0] = idCount;
		        		}
		        	}else {
		        		maxMap.put(longarr[i], 1);
		        	}
		        }
	        	maxMap.values().forEach(v->{
	        		if(maxCount[0]==v) {
	        			maxID[0]++;
	        		}
	        	});;
		       System.out.println(maxID[0]);
	        }
	    }
	}
}
