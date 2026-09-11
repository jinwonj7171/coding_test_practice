package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA8275 {
	static int X;
	static int N;
	static int[][] arr;
	static int[] cages;
	static int[] result;
	static int max_sum;
	static int[] max_cages;
	static boolean found;

	static void dfs(int idx) {
		if (idx == N) {
			// 모든 우리의 숫자가 결정됨
			// M개의 기록을 모두 만족하는지검사
			for (int i = 0; i < arr.length; i++) {

				int li = arr[i][0];
				int ri = arr[i][1];
				int si = arr[i][2];
				int checksum = 0;
				for (int j = li - 1; j < ri; j++) {
					checksum += cages[j];
				}
				if (checksum != si) {
					return;
				}

			}
			found = true;
			int checksum2 = 0;
			for (int i = 0; i < cages.length; i++) {
				checksum2 += cages[i];

			}

			if (checksum2 > max_sum) {
				max_cages = cages.clone();
				max_sum = checksum2;
				return;
			} else if (checksum2 == max_sum) {
				for (int i = 0; i < cages.length; i++) {
					if (max_cages[i] > cages[i]) {
						max_cages = cages.clone();
						return;
					} else if (max_cages[i] < cages[i]) {

						return;
					}

				}

			}
			return;

		}
		for (int hamsters = 0; hamsters <= X; hamsters++) {
			cages[idx] = hamsters;
			dfs(idx + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_8275.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[M][3];
			cages = new int[N];
			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int li = Integer.parseInt(st2.nextToken());
				int ri = Integer.parseInt(st2.nextToken());
				int si = Integer.parseInt(st2.nextToken());
				arr[i] = new int[] { li, ri, si };
			}
			max_cages = new int[N];
			max_sum = 0;
			found = false;
			dfs(0);

			sb.append("#").append(tc).append(" ");
//			boolean flag = false;
//			for (int i = 0; i < max_cages.length; i++) {
//				if (max_cages[i] != 0) {
//					flag = true;
//				}
//			}
			if (found) {
				for (int i = 0; i < max_cages.length; i++) {
					sb.append(max_cages[i]).append(" ");
				}
			} else {
				sb.append(-1);
			}

			sb.append("\n");

		}
		System.out.println(sb);

	}

}
