package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA14510 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_14510.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			int num = Integer.parseInt(br.readLine());
			int top = 0;
			int[] arr = new int[num];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < num; i++) {
				int ele = Integer.parseInt(st.nextToken());
				arr[i] = ele;
				top = Math.max(top, ele);
			}
			int count = 0;
			int even = 0; // 짝수
			int odd = 0; // 홀수
			for (int i = 0; i < num; i++) {
				int temp = top - arr[i];
				even += temp / 2;
				odd += temp % 2;
			}
			while (even > odd + 1) {
				even--;
				odd += 2;
			}
			if (odd > even) {
				count = odd * 2 - 1;
			} else {
				count = even * 2;
			}

			sb.append("#").append(tc).append(" ").append(count).append("\n");

		}
		System.out.println(sb);

	}

}
