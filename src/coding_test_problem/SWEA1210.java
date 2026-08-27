package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1210 {
	static int[] dr = { -1, 0, 0 };
	static int[] dc = { 0, 1, -1 };
	static int[][] arr;
	static int[][] visited;

	static String doublecheck(int x, int y) {
		for (int i = 1; i < 3; i++) {
			int dx = x + dr[i];
			int dy = y + dc[i];
			if (dx >= 0 && dy >= 0 && dx < 100 && dy < 100 && visited[dx][dy] != 1 && arr[dx][dy] == 1) {
				if (i == 1) {
					return "right";
				} else {
					return "left";
				}

			}

		}
		return "up";

	}

	static int check(int start) {
		visited[99][start] = 1;
		int x = 99;
		int y = start;
		while (x != 0) {
			String way = doublecheck(x, y);
			if (way.equals("right")) {
				x += dr[1];
				y += dc[1];
				visited[x][y] = 1;
			} else if (way.equals("left")) {
				x += dr[2];
				y += dc[2];
				visited[x][y] = 1;
			} else if (way.equals("up")) {
				x += dr[0];
				y += dc[0];
				visited[x][y] = 1;
			}

		}
		return y;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1210.txt"));
		StringBuilder sb = new StringBuilder();
		int n = 10;
		for (int tc = 1; tc <= n; tc++) {
			int tcnum = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int start = 0;
			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2) {
					start = i;
				}
			}
			visited = new int[100][100];

			int result = check(start);

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}
