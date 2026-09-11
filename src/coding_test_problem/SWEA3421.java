package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA3421 {
	static boolean[][] imp;
	static int N;
	static int result;
	static boolean[] check_list;

	static void check(int depth) {

		if (depth == N + 1) {
//			System.out.println(Arrays.toString(check_list));
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j <= N; j++) {
					if (check_list[i] && imp[i][j] && check_list[j]) {
//						System.out.println("here!!");
						return;
					}
				}
			}

			result += 1;
			return;
		}
		check_list[depth] = true;
		check(depth + 1);
		check_list[depth] = false;
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
