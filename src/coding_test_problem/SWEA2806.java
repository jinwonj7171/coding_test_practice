package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA2806 {
	static int result;

	static int N;
	static int[] dc = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dr = { 0, 0, -1, 1, 1, -1, -1, 1 };

	static void setline(int x, int y, int[][] arr) {
		for (int i = 0; i < 8; i++) {

			int nx = x;
			int ny = y;

			nx += dc[i];
			ny += dr[i];
			while (nx >= 0 && ny >= 0 && nx < N && ny < N) {

				arr[nx][ny] = 1;

				nx += dc[i];
				ny += dr[i];

			}

		}

	}

	static boolean check(int x, int y, int[][] arr) {
		for (int i = 0; i < 6; i++) {

			int nx = x;
			int ny = y;
			nx += dc[i];
			ny += dr[i];
			while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (arr[nx][ny] != 0) {
					return false;
				}
				nx += dc[i];
				ny += dr[i];

			}

		}
		return true;
	}

	static void dfs(int[][] arr, int idx) {
		if (idx == N) {
			result += 1;
			return;
		}

		for (int j = 0; j < N; j++) {
			if (arr[idx][j] == 0) {
				int[][] arr2 = new int[N][N];
				for (int r = 0; r < N; r++) {
					arr2[r] = arr[r].clone();
				}
				arr2[idx][j] = 2;
				setline(idx, j, arr2);
				dfs(arr2, idx + 1);
			}
		}

		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_2806.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			result = 0;
			dfs(arr, 0);

			sb.append("#").append(tc).append(" ").append(result).append("\n");

		}
		System.out.println(sb);

	}

}
