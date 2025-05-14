package com.learn.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TramRide {
	public static void main(String[] args) throws IOException {
		
//		System.out.println(solve(4,1,4,new int[] {1,2,2,4}));
		
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("288905387ba111ed.TramRide.txt")));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         int start = Integer.parseInt(br.readLine().trim());
         int finish = Integer.parseInt(br.readLine().trim());
         String[] arr_Ticket_cost = br.readLine().split(" ");
         int[] Ticket_cost = new int[N];
         for(int i_Ticket_cost = 0; i_Ticket_cost < arr_Ticket_cost.length; i_Ticket_cost++)
         {
         	Ticket_cost[i_Ticket_cost] = Integer.parseInt(arr_Ticket_cost[i_Ticket_cost]);
         }

         long out_ = solve(N, start, finish, Ticket_cost);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static long solve(int N, int start, int finish, int[] Ticket_cost){
       // Write your code here
        long result = 0;
        int newStart =start;
        int newFinish =finish;
        
//        for(int k=0;k<Ticket_cost.length;k++) {
//        	System.out.print(k+1+"--("+Ticket_cost[k]+")-->");
//        }
//        System.out.println();
        
        if(start > finish) {
        	newStart = finish;
        	newFinish = start;
        }
        

    	long forwardCost = 0;
    	for(int i=newStart-1;i<newFinish-1;i++) {
    		forwardCost += Ticket_cost[i];
//    		System.out.print(i+1+":("+Ticket_cost[i]+","+forwardCost+")+");
    	}
//    	System.out.println();
    	long reverseCost1 = 0;
    	long reverseCost2 = 0;
//    	System.out.print("\nFirstPart :");
    	for(int i=0;i<newStart-1;i++) {
    		reverseCost1 += Ticket_cost[i];
//    		System.out.print(i+1+":("+Ticket_cost[i]+","+reverseCost1+")+");
    	}
//    	System.out.print("\nsecondpart :");
    	for(int i=N-1;i>=newFinish-1;i--) {
    		reverseCost2 += Ticket_cost[i];
//    		System.out.print(i+1+":("+Ticket_cost[i]+","+reverseCost2+")+");
    	}
    	
//    	System.out.println();
    	result = (forwardCost<(reverseCost1+reverseCost2))? forwardCost : (reverseCost1+reverseCost2);
    
        return result;
    
    }
}
