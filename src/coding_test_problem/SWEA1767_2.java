package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1767_2 {
	static List<int[]> cores;
	static int[][] arr;
	static int min_count;
	static int num;
	static int max_core;
	static int check(int dir, int x, int y) {
		int flag = 0;
		// 1 상, 2 하, 3 좌, 4 우
		switch (dir) {
		case 1:
			flag = 0;
			for (int i = 0; i < x; i++) {
				if (arr[i][y] != 0) {
					flag = 1;
				}
			}
			if (flag == 0) {
				for (int i = 0; i < x; i++) {
					arr[i][y] = 2;
				}
				return x;
			}
			break;
		case 2:
			flag = 0;
			for (int i = x + 1; i < num; i++) {
				if (arr[i][y] != 0) {
					flag = 1;
				}
			}
			if (flag == 0) {
				for (int i = x + 1; i < num; i++) {
					arr[i][y] = 2;
				}
				return num - x - 1;
			}
			break;
		case 3:
			flag = 0;
			for (int i = 0; i < y; i++) {
				if (arr[x][i] != 0) {
					flag = 1;
				}
			}
			if (flag == 0) {
				for (int i = 0; i < y; i++) {
					arr[x][i] = 2;

				}
				return y;
			}
			break;
		case 4:
			flag = 0;
			for (int i = y + 1; i < num; i++) {
				if (arr[x][i] != 0) {
					flag = 1;
				}
			}
			if (flag == 0) {
				for (int i = y + 1; i < num; i++) {
					arr[x][i] = 2;
				}
				return num - y - 1;
			}
			break;
		default:
			return 0;

		}
		return 0;
	}

	static void remove(int dir, int x, int y) {

		// 1 상, 2 하, 3 좌, 4 우
		switch (dir) {
		case 1:
			for (int i = 0; i < x; i++) {
				arr[i][y] = 0;
			}
			break;
		case 2:

			for (int i = x + 1; i < num; i++) {
				arr[i][y] = 0;
			}
			break;
		case 3:

			for (int i = 0; i < y; i++) {
				arr[x][i] = 0;
			}

			break;
		case 4:

			for (int i = y + 1; i < num; i++) {
				arr[x][i] = 0;
			}

		}
	}

	static void dfs(int idx, int connected,int count) {
		if (idx == cores.size()) {
			
        
            if (connected > max_core) {
                max_core = connected;
                min_count = count;
            }

          
            else if (connected == max_core) {
                min_count = Math.min(min_count, count);
            }
			return;
		}
		int[] cur = cores.get(idx);
		int x = cur[0];
		int y = cur[1];
		for (int i = 1; i <= 4; i++) {
			int result = check(i, x, y);
			if (result != 0) {
				dfs(idx + 1, connected +1,count + result);
				remove(i, x, y);
			}
		}
		dfs(idx+1,connected,count);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1767.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			num = Integer.parseInt(br.readLine());
			arr = new int[num][num];
			cores = new ArrayList<>();
			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < num; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1 && i != 0 && j != 0 && i != num - 1 && j != num - 1) {
						cores.add(new int[] { i, j });
					}
				}
			}
			max_core =0;
			min_count = Integer.MAX_VALUE;
			dfs(0, 0,0);

			sb.append("#").append(tc).append(" ").append(min_count).append("\n");

		}
		System.out.println(sb);

	}

}
