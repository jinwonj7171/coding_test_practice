package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1984 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1984.txt"));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr = new int [10];
			for (int j = 0; j < 10; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			int min = 10000;
			int result =0;
			for (int j = 0; j < 10; j++) {
				result+=arr[j];
				if(max<arr[j]) {
					max = arr[j];
				}
				if(min>arr[j]) {
					min = arr[j];
				}
				
			}
			if(max ==min) {
				System.out.println(i+1);
				
			}
			result -=max;
			result-=min;
			int average = (int) Math.round(result/8.0);
			System.out.printf("#%d %d",i+1,average);
			System.out.println();
			
		}

	

	}

}
