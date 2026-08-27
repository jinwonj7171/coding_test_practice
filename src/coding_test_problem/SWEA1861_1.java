package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1861_1 {
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
 	
	
	
	
	static int check(int[][] arr,int x, int y,int num,int result,int count) {
		for (int i = 0; i < 4; i++) {
			int x_dr = x+dr[i];
			int y_dc = y+dc[i];
			if(x_dr>=0&&y_dc>=0&&x_dr<num&&y_dc<num&&arr[x_dr][y_dc] == arr[x][y]+1) {
				return 1+ check(arr,x_dr,y_dc,num,result,count+1);
			}

		}


		return 1;
	}
	
	

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1861.txt"));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= n; tc++) {
			int num = Integer.parseInt(br.readLine());
			int [][] arr = new int [num][num];
			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < num; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int min_result = Integer.MAX_VALUE;
			int max_count = Integer.MIN_VALUE;
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					int result =arr[i][j];
					int count =0;
					count = check(arr,i,j,num,result,count);
					if (max_count<count) {
						max_count = count;
						min_result = result;
					}
					else if (max_count == count) {
						if(min_result>result) {
							min_result = result;
						}
					}
				}
			}

			
			
			
			
			sb.append("#").append(tc).append(" ").append(min_result).append(" ").append(max_count).append("\n");
		}
		System.out.println(sb);

	
		

	}

}
