package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA4796_1 {
	static int[] arr;
	static int num, count;

	static int left(int idx) {

		if (idx >= 0) {
			if (arr[idx + 1] > arr[idx]) {
				return 1;
			}

		}
		return 0;
	}

	static int right(int idx) {

		if (idx < num) {
			if (arr[idx - 1] > arr[idx]) {
				return 1;
			}
		}
		return 0;

	}

	static void checking(int idx) {
		int right_idx = idx + 1;
		int left_idx = idx - 1;
		while (left(left_idx - 1) == 1 || right(right_idx + 1) == 1) {
			count += left(left_idx);
			count += right(right_idx);

			left_idx -= 1;
			right_idx += 1;
		}
	}

	static void check(int idx) {
		if (idx == num - 1) {
			return;
		}
		if (left(idx - 1) == 1 && right(idx + 1) == 1) {
			count += 1;

			checking(idx);

		}
		check(idx + 1);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_4796.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			num = Integer.parseInt(br.readLine());
			arr = new int[num];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			count = 0;
			check(1);

			sb.append("#").append(tc).append(" ").append(count).append("\n");

		}
		System.out.println(sb);

	}

}
