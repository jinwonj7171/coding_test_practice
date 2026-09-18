package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA5648_2 {
	static int N = 4001;
	static int[][] map = new int[N][N];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Unit {
		int x, y, dir, e;

		public Unit(int x, int y, int dir, int e) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_5648.txt"));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int totalEnergy = 0;
			int count = Integer.parseInt(br.readLine());
			ArrayDeque<Unit> dq = new ArrayDeque<>();
			for (int i = 0; i < count; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = (Integer.parseInt(st.nextToken()) + 1000) << 1;
				int y = (Integer.parseInt(st.nextToken()) + 1000) << 1;
				int dir = (Integer.parseInt(st.nextToken()));
				int e = (Integer.parseInt(st.nextToken()));
				map[y][x] = e;
				dq.addLast(new Unit(x, y, dir, e));
			}
			while (!dq.isEmpty()) {
				Unit cur = dq.pollFirst();
				// 이 위치에서 충돌 만약, 충돌이 일어난 다른 원자 차례가 오면 0 이므로 +=0처리로 이론상 이상 x
				if (map[cur.y][cur.x] != cur.e) {
					totalEnergy += map[cur.y][cur.x];
					map[cur.y][cur.x] = 0;
					continue;
				}

				map[cur.y][cur.x] = 0;
				int nx = cur.x + dx[cur.dir];
				int ny = cur.y + dy[cur.dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				cur.x = nx;
				cur.y = ny;
				map[cur.y][cur.x] += cur.e;
				dq.addLast(cur);
			}

			sb.append("#").append(tc).append(" ").append(totalEnergy).append("\n");

		}
		System.out.println(sb);

	}

}
