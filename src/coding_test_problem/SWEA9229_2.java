package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA9229_2 {
	static int limit_weight;
	static int max_weight;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_9229.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			limit_weight = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st2.nextToken());
			}
			max_weight = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int weight = arr[i] + arr[j];
					if (weight > max_weight && weight <= limit_weight) {
						max_weight = weight;
					}

				}
			}

			sb.append("#").append(tc).append(" ").append(max_weight).append("\n");
		}
		System.out.println(sb);

	}

}
