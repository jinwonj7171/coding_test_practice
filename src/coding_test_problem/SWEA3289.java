package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA3289 {
	static int[] arr, wei;
	static StringBuilder sb;

	static int find(int x) {
		if (arr[x] == x) {
			return x;
		}
		return arr[x] = find(arr[x]);
	}

	static void union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);

		if (rootx == rooty) {
			return;
		}
		if (wei[rootx] < wei[rooty]) {
			int temp = rootx;
			rootx = rooty;
			rooty = temp;
		}

		arr[rooty] = rootx;
		wei[rootx] += wei[rooty];

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_3289.txt"));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n + 1];
			wei = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
				wei[i] = 1;
			}

			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (op == 0) {
					union(a, b);
				} else {
					if (find(a) == find(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}

			}
			sb.append("\n");

		}
		System.out.println(sb);

	}

}
