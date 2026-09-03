package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA9229 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_9229.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st2.nextToken());
			}
			Arrays.sort(arr);
			int left = 0;
			int right = N - 1;
			int max_weight = -1;
			while (left < right) {
				int weight = arr[left] + arr[right];
				if (weight <= M) {
					max_weight = Math.max(max_weight, weight);
					left++;
				} else {
					right--;
				}

			}

			sb.append("#").append(tc).append(" ").append(max_weight).append("\n");
		}
		System.out.println(sb);

	}

}
