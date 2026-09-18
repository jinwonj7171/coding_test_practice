package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA2115 {
	static int[][] arr;
	static int N, M, C, one;
	static StringTokenizer st;
	static ArrayList<int[]> list;

	static int cal(Queue<Integer> q) {
		int[] temp = new int[M];
		for (int i = 0; i < M; i++) {
			temp[i] = q.poll();
		}
		int max = 0;
		for (int mask = 0; mask < (1 << M); mask++) {
			int sum = 0;
			int profit = 0;
			for (int i = 0; i < M; i++) {
				if ((mask & (1 << i)) != 0) {
					sum += temp[i];
					profit += temp[i] * temp[i];
				}
			}
			if (sum <= C) {
				max = Math.max(max, profit);
			}
		}
		return max;

	}

	static void check() {
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			q = new ArrayDeque<>();
			for (int j = 0; j < M; j++) {
				q.offer(arr[i][j]);

			}
			int result = cal(new ArrayDeque<>(q));
			list.add(new int[] { i, M - 1, result });
			for (int j = M; j < N; j++) {
				q.poll();
				q.offer(arr[i][j]);
				result = cal(new ArrayDeque<>(q));
				list.add(new int[] { i, j, result });

			}
		}

	}

	static void ranking() {
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int r1 = list.get(i)[0];
				int c1 = list.get(i)[1];
				int r2 = list.get(j)[0];
				int c2 = list.get(j)[1];

				if (r1 == r2 && Math.abs(c1 - c2) < M) {
					continue;
				}
				int profit = list.get(i)[2] + list.get(j)[2];
				max = Math.max(max, profit);

			}
		}
		one = max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_2115.txt"));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			one = 0;
			list = new ArrayList<>();
			check();
			ranking();
			sb.append("#").append(tc).append(" ").append(one).append("\n");

		}
		System.out.println(sb);

	}

}
