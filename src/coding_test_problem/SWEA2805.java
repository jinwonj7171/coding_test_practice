package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA2805 {
	static int N;
	static int count;
	static int [][] arr;
	static void search() {
		int center = N/2;
		int index = 0;
		for (int i = 0; i < N/2; i++) {
			for (int j = center-index; j <= center+index; j++) {
				count +=arr[i][j];
				count += arr[N-i-1][j];
			}
			index++;
		}
		for (int i = 0; i < N; i++) {
			count+=arr[center][i];
		}
	}

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_2805.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= n; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = row.charAt(j) - '0';
				}
			}
			count=0;
			search();
			sb.append("#")
			.append(tc)
			.append(" ")
			.append(count)
			.append("\n");
			
		}
		System.out.println(sb);

	
		

	}

}
