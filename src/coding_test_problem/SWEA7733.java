package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA7733 {
	static int N, max;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	static void bfs(int sr, int sc, int day) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { sr, sc });
		visited[sr][sc] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (visited[nr][nc])
					continue;
				if (arr[nr][nc] <= day)
					continue;

				visited[nr][nc] = true;
				q.offer(new int[] { nr, nc });

			}

		}

	}

	static void check() {
		for (int day = 0; day <= 100; day++) {
			visited = new boolean[N][N];
			int count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > day && !visited[i][j]) {

						count++;
						bfs(i, j, day);

					}
				}
			}
			max = Math.max(max, count);

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_7733.txt"));
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
			check();

			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}

}
