package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA4796 {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("input/swea_4796.txt"));
//		int n = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
//			int num = Integer.parseInt(br.readLine());
//			int[] arr = new int[num];
//			StringTokenizer st = new StringTokenizer(br.readLine()," ");
//			for (int i = 0; i < num; i++) {
//				arr[i] = Integer.parseInt(st.nextToken());
//			}
			int num = sc.nextInt();
			int[] arr = new int[num];

			for (int i = 0; i < num; i++) {
				arr[i] = sc.nextInt();
			}
			long count = 0;
			int up = 0;
			int down = 0;
			for (int i = 1; i < num; i++) {
				if (arr[i - 1] < arr[i]) {
					if (down > 0) {
						count += (long) up * down;
						up = 0;
						down = 0;

					}

					up++;
				} else {
					if (up > 0) {
						down++;
					}

				}

			}
			if (up > 0 && down > 0) {
				count += (long) up * down;
			}

			sb.append("#").append(tc).append(" ").append(count).append("\n");

		}
		System.out.println(sb);

	}

}
