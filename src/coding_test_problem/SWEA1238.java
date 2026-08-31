package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1238 {

	static int bfs(List<Integer>[] graph, int start) {
		boolean[] visited = new boolean[101];
		Deque<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.offer(start);
		int result = start;
		while (!q.isEmpty()) {
			int size = q.size();
			result = 0;
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				result = Math.max(result, cur);
				for (int ele : graph[cur]) {
					if (!visited[ele]) {
						q.offer(ele);
						visited[ele] = true;
					}

				}
			}

		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1238.txt"));
		StringBuilder sb = new StringBuilder();
		int n = 10;
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			List<Integer>[] graph = new ArrayList[101];
			for (int i = 0; i <= 100; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < num / 2; i++) {
				int from = Integer.parseInt(st2.nextToken());
				int to = Integer.parseInt(st2.nextToken());
				graph[from].add(to);

			}
			int result = bfs(graph, start);

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}
