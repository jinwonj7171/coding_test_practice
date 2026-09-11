package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA6808 {
	static final int depth = 9;
	static boolean[] visited = new boolean[9];
	static int[] result = new int[9];
	static int win;
	static int lose;

	static int fight(int[] first, int[] second) {
		int first_win = 0;
		int second_win = 0;
		for (int i = 0; i < 9; i++) {
			if (first[i] > second[i]) {
				first_win += first[i] + second[i];

			} else {
				second_win += first[i] + second[i];
			}
		}
		if (first_win > second_win) {
			return 1;
		} else if (second_win > first_win) {
			return -1;
		} else {
			return 0;
		}

	}

	static void permutation(int[] first, int[] second, int cur_depth) {
		if (cur_depth == depth) {
			int result_num = fight(first, result);
			if (result_num == 1) {
				win += 1;
			} else if (result_num == -1) {
				lose += 1;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[cur_depth] = second[i];
				permutation(first, second, cur_depth + 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_6808.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] first = new int[9];
			int[] second = new int[9];
			for (int i = 0; i < 9; i++) {
				first[i] = Integer.parseInt(st.nextToken());
			}
			int index = 0;
			for (int i = 1; i <= 18; i++) {
				boolean flag = false;
				for (int j = 0; j < first.length; j++) {
					if (i == first[j]) {
						flag = true;
					}
				}
				if (flag == false) {
					second[index++] = i;
				}
			}

			int cur_depth = 0;
			win = 0;
			lose = 0;
			permutation(first, second, cur_depth);

			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);

	}

}
