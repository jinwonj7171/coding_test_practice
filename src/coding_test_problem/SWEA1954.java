package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1954 {
	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0};
	static int [][] arr;
	static int dir;
	static int num;
	static void check (int [][]arr) {
		dir =0;
		int x =0;
		int y =0;
		for (int i = 1; i <= num*num; i++) {
			if(i==1) {
				arr[0][0] = i;
				x = x+dr[dir%4];
				y = y+dc[dir%4];
				continue;
			}

//			System.out.println(dir%4);
			if(x>=0&&y>=0&&x<num&&y<num&&arr[x][y]==0) {
				arr[x][y] = i;

				
			}
			else {
				int x_dr = x-dr[dir%4];
				int y_dc = y-dc[dir%4];
				dir++;
				x_dr = x_dr+dr[dir%4];
				y_dc = y_dc+dc[dir%4];
				if(x_dr>=0&&y_dc>=0&&x_dr<num&&y_dc<num&&arr[x_dr][y_dc]==0) {
					arr[x_dr][y_dc] = i;
					x = x_dr;
					y = y_dc;
					
				}
			}
			x = x+dr[dir%4];
			y = y+dc[dir%4];
//			for (int j = 0; j < num; j++) {
//				System.out.println(Arrays.toString(arr[j]));
//		}

//
//		System.out.println("----------------------------------------------------");
			
		}

	}
	
	

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1954.txt"));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= n; tc++) {
			num = Integer.parseInt(br.readLine());
			arr = new int [num][num];
			
//			for (int i = 0; i < num; i++) {
//				for (int j = 0; j < num; j++) {
//					check(arr,i,j,index,dir);
//					index++;
//				}
//			}
			check(arr);
			
			
			
			
			
			
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
				
				
			}
//			if(tc==4) {
//				break;
//			}
			
		}
		System.out.println(sb);
	
		

	}

}
