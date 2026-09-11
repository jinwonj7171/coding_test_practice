package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1219 {
	static List<Integer>[] graph;
	static final int end = 99;

	static int dfs(int start) {
		if (start == end) {

			return 1;
		}
		List<Integer> cur = graph[start];
		for (Integer ele : cur) {
			if (dfs(ele) == 1) {
				return 1;
			}

		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1219.txt"));
		StringBuilder sb = new StringBuilder();
		int n = 10;
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int tc_num = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			graph = new ArrayList[100];
			for (int i = 0; i < 100; i++) {
				graph[i] = new ArrayList<>();
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < num; i++) {
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				graph[a].add(b);
			}
			int start = 0;

			int result = dfs(start);

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}
