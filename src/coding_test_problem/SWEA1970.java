package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1970 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1970.txt"));
		int n = Integer.parseInt(br.readLine());
		int [] arr = {50000,10000,5000,1000,500,100,50,10};
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			int [] result = new int [arr.length];
			for (int j = 0; j < arr.length; j++) {
				while(arr[j]<=num) {
					result[j]+=1;
					num -=arr[j];
					
				}
			}
			System.out.printf("#%d",i+1);
			System.out.println();
			for (int j = 0; j < result.length; j++) {
				System.out.printf("%d ",result[j]);
			}
			System.out.println();
		}

	
		

	}

}
