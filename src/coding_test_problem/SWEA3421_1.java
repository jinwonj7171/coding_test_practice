package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA3421_1 {
	static boolean[][] imp;
	static int N;
	static int result;
	static boolean[] check_list;

	static void check(int depth) {
		if (depth == N + 1) {
			result++;
			return;
		}

		// depth 번 재료를 선택할 수 있는지 검사
		boolean possible = true;
		for (int i = 1; i < depth; i++) {
			if (check_list[i] && imp[i][depth]) {
				possible = false;
				break;
			}
		}

		// depth 번 재료 선택
		if (possible) {
			check_list[depth] = true;
			check(depth + 1);
			check_list[depth] = false;
		}

		// depth번 재료 선택하지 않음
		check(depth + 1);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_3421.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			imp = new boolean[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				imp[a][b] = true;
				imp[b][a] = true;

			}
			check_list = new boolean[N + 1];
			result = 0;
			check(1);

			sb.append("#").append(tc).append(" ").append(result).append("\n");

		}
		System.out.println(sb);

	}

}
