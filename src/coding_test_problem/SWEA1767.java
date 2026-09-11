package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1767 {
	static int[][] cells;
	static List<int[]> cores;
	static int max_core, min_line;
	static int num;
	static int[] dc = { -1, 1, 0, 0 };
	static int[] dr = { 0, 0, -1, 1 };

	static boolean check(int dir, int x, int y) {
		int nx = x + dc[dir];
		int ny = y + dr[dir];
		while (nx >= 0 && ny >= 0 && nx < num && ny < num) {
			if (cells[nx][ny] != 0) {
				return false;
			}
			nx += dc[dir];
			ny += dr[dir];
		}
		return true;
	}

	static int setline(int dir, int val, int x, int y) {
		int nx = x + dc[dir];
		int ny = y + dr[dir];
		int line = 0;

		while (nx >= 0 && ny >= 0 && nx < num && ny < num) {
			line += 1;
			cells[nx][ny] = val;
			nx += dc[dir];
			ny += dr[dir];
		}
		return line;
	}

	static void dfs(int core, int line, int idx) {
		if (idx == cores.size()) {
			if (max_core < core) {
				max_core = core;
				min_line = line;
			} else if (max_core == core) {
				min_line = Math.min(min_line, line);
			}
			return;
		}

		int[] cur = cores.get(idx);
		int x = cur[0];
		int y = cur[1];
		for (int i = 0; i < 4; i++) {
			if (!check(i, x, y))
				continue;
			int plus = setline(i, 2, x, y);

			dfs(core + 1, line + plus, idx + 1);
//			for (int j = 0; j < num; j++) {
//				System.out.println(Arrays.toString(cells[j]));
//			}
//			System.out.println("----------------------------------");
			setline(i, 0, x, y);

		}

		dfs(core, line, idx + 1);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1767.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			num = Integer.parseInt(br.readLine());
			cells = new int[num][num];
			cores = new ArrayList<>();
			int plus_core = 0;
			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < num; j++) {
					cells[i][j] = Integer.parseInt(st.nextToken());
					if (cells[i][j] == 1 && i >= 0 && j >= 0 && i < num && j < num) {
						if (i == 0 || j == 0 || i == num - 1 || j == num - 1) {
							plus_core += 1;
						} else {
							cores.add(new int[] { i, j });
						}

					}

				}
			}
			max_core = 0;
			min_line = Integer.MAX_VALUE;

			dfs(0, 0, 0);

			sb.append("#").append(tc).append(" ").append(min_line).append("\n");
		}
		System.out.println(sb);

	}

}
