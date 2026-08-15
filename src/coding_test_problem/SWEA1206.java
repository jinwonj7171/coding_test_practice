package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1206 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1206.txt"));
		int n = 10;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <=n; tc++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st  = new StringTokenizer(br.readLine()," ");
			int [] arr = new int [num];
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int result = 0;
			for (int i = 2; i < num-2; i++) {
				int left_max = Math.max(arr[i-2],arr[i-1]);
				int right_max = Math.max(arr[i+2],arr[i+1]);
				int total_max = Math.max(right_max,left_max);
				if(arr[i]>total_max) {
					result +=arr[i] - total_max;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);

	
		

	}

}
