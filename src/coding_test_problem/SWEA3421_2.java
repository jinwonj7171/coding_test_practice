package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA3421_2 {
	static int[] imp;
	static int N;
	static int result;

	static void dfs(int depth, int mask) {
		if (depth == N) {
			result++;
			return;
		}
		// depth번 재료와 충돌하는 재료가 현재 mask에 하나라도 있는지 확인
		if ((mask & imp[depth]) == 0) {
			dfs(depth + 1, mask | (1 << depth));
		}
		dfs(depth + 1, mask);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_3421.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			imp = new int[N];

			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken()) - 1;
				int b = Integer.parseInt(st2.nextToken()) - 1;
				imp[a] |= (1 << b);
				imp[b] |= (1 << a);

			}

			result = 0;
			dfs(0, 0);

			sb.append("#").append(tc).append(" ").append(result).append("\n");

		}
		System.out.println(sb);

	}

}
