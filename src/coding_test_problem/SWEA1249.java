package coding_test_problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA1249 {
	static int num;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] dist;

	static void check() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
		dist[0][0] = 0;
		pq.offer(new int[] { 0, 0, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];

			if (cost > dist[r][c]) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nc >= 0 && nr < num && nc < num) {
					int newCost = cost + map[nr][nc];
					if (newCost < dist[nr][nc]) {
						dist[nr][nc] = newCost;
						pq.offer(new int[] { nr, nc, newCost });
					}

				}

			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1249.txt"));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= n; tc++) {
			num = Integer.parseInt(br.readLine());
			map = new int[num][num];
			for (int i = 0; i < num; i++) {
				String line = br.readLine();
				for (int j = 0; j < num; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			dist = new int[num][num];
			for (int i = 0; i < num; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}

			check();

			sb.append("#").append(tc).append(" ").append(dist[num - 1][num - 1]).append("\n");

		}
		System.out.println(sb);

	}

}
