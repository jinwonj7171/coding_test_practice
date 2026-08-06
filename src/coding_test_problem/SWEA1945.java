package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1945 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1945.txt"));
		int n = Integer.parseInt(br.readLine());
		int [] arr= {2,3,5,7,11};
		for (int i = 0; i < n; i++) {
			int [] result= new int [5];
			int num = Integer.parseInt(br.readLine());
			for (int j = 4; j >= 0; j--) {

				while((num%arr[j]) ==0) {
					result[j]+=1;
					num = num/arr[j];
					
					
				}
			}
			System.out.printf("#%d",i+1);
			for (int j = 0; j <arr.length ; j++) {
				
				System.out.printf(" %d",result[j]);
			}
			System.out.println();
			
			
			
		}

	
		

	}

}
