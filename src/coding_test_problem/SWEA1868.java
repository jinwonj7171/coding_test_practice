package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1868 {
	static int N;
	static char[][] arr;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static char checking_zero(int r, int c) {
		int result = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (arr[nr][nc] == '*') {
					result += 1;
				}
			}
		}

		return (char) (result + '0');
	}

	static void checking(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int [] {r,c});
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int nr = cur[0];
			int nc = cur[1];
			if(arr[nr][nc] !='0') {
				continue;
			}
			for (int i = 0; i < 8; i++) {
				int nrr = nr + dr[i];
				int ncc = nc + dc[i];
				if(nrr >= 0 && ncc >= 0 && nrr < N && ncc < N) {
					if(arr[nrr][ncc] == '.') {
						arr[nrr][ncc] = checking_zero(nrr, ncc);
						if(arr[nrr][ncc] == '0') {
							q.offer(new int[] {nrr,ncc});
						}
					}
				}
			}
			
			
		}
	}

	static int check() {
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != '.')
					continue;
				if (checking_zero(i, j) == '0') {
					count++;
					arr[i][j] = '0';
					checking(i, j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '.') {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1868.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String data = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = data.charAt(j);
				}
			}
			int result = check();
			sb.append("#")
			.append(tc)
			.append(" ")
			.append(result)
			.append("\n");
		}
		System.out.println(sb);

	}

}
