package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA2112 {
	static int D, W, K, min_count;
	static int[] arr;

	static boolean checking() {
		int full = (1<<W)-1;
		int satisfied = 0;
		for (int start = 0; start < D-K; start++) {
			int allone = full;
			int anyone = 0;
			for (int i = start; i <=  i+K; i++) {
				allone &= arr[i];
				anyone |= arr[i];
			}
			int allzero = (~anyone) & full;
			int pass = allone | allzero;
			satisfied|=pass;
		}
		return satisfied == full;
	}

	static void check(int idx, int count) {
		if (count >= min_count) {
			return;
		}

		if (idx == D) {
			if (checking()) {
				min_count =count;
			}
			return;
		}

		int temp = arr[idx];
		arr[idx] = 0;
		check(idx + 1, count + 1);
		arr[idx] = (1 << W) - 1;
		check(idx + 1, count + 1);
		arr[idx] = temp;
		check(idx + 1, count);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_2112.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int input = Integer.parseInt(st.nextToken());
					if (input == 1) {
						arr[i] |= (1 << j);
					}
				}
			}
			min_count = 0;

			if (!checking()) {
				min_count = K;
				check(0, 0);
			}

			sb.append("#")
			.append(tc)
			.append(" ")
			.append(min_count)
			.append("\n");

		}
		System.out.println(sb);

	}

}
