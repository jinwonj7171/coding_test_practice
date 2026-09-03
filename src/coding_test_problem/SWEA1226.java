package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1226 {
	static int [][] path = new int[16][16];
	static int [] dc = {-1,1,0,0};
	static int [] dr = {0,0,-1,1};
	static int [][] visited;
	static final int endx = 13;
	static final int endy = 13;
	static void move (int x,int y) {
		if(x==endx && y ==endy) {
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dc[i];
			int ny = y+ dr[i];
			
			if(path[nx][ny] != 1 && visited[nx][ny] ==0) {
				visited[nx][ny] = 1;
				move(nx,ny);
			}
			
			
		}
		
	}
	

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1226.txt"));
		int n = 10;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			int num = Integer.parseInt(br.readLine());
			for (int i = 0; i < 16; i++) {
				String data = br.readLine();
				for (int j = 0; j < 16; j++) {
					path[i][j] = data.charAt(j)-'0';
				}
			}
			visited = new int[16][16];
			
			move(1,1);
			sb.append("#")
			.append(tc)
			.append(" ")
			.append(visited[13][13])
			.append("\n");
			
//			for (int i = 0; i < 16; i++) {
//				System.out.println(Arrays.toString(path[i]));
//			}
		}
		System.out.println(sb);
		

	
		

	}

}
