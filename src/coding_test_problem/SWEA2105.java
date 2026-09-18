package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA2105 {
	static int N, max;
	static int[][] arr;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static boolean[] dessert = new boolean[101];

	static void dfs(int r, int c, int dir, int sr, int sc,int count) {
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		if(nr >=0 && nc >=0 &&nr<N&&nc<N) {
			if(nr == sr && nc ==sc) {
				if(dir ==3) {
					max = Math.max(max, count);
				}
			}
			else {
				int value = arr[nr][nc];
				if(!dessert[value]) {
					dessert[value] = true;
					dfs(nr,nc,dir,sr,sc,count+1);
					dessert[value] = false;
				}
			}
		}
		if (dir < 3) {

		    int nextDir = dir + 1;

		    nr = r + dr[nextDir];
		    nc = c + dc[nextDir];

		    if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
		        if (nr == sr && nc == sc) {
		            if (nextDir == 3) {
		                max = Math.max(max, count);
		            }
		        } else {
		            int value = arr[nr][nc];
		            if (!dessert[value]) {
		                dessert[value] = true;
		                dfs(nr, nc, nextDir, sr, sc, count + 1);
		                dessert[value] = false;
		            }
		        }
		    }
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_2105.txt"));
	
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dessert = new boolean[101];
					dessert[arr[i][j]] = true;
					dfs(i, j, 0, i, j, 1);
					dessert[arr[i][j]] = false;
				}
			}

			max = (max != 0) ? max : -1;
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}

}
