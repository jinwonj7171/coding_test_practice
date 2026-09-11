package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1952 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1952.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int dayprice = Integer.parseInt(st.nextToken());
			int monthprice = Integer.parseInt(st.nextToken());
			int threemonthprice = Integer.parseInt(st.nextToken());
			int yearprice = Integer.parseInt(st.nextToken());
			int[] plan = new int[13];
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < 13; i++) {
				plan[i] = Integer.parseInt(st2.nextToken());
			}

			int[] dp = new int[13];
			for (int i = 1; i < 13; i++) {
				int useday = dp[i - 1] + dayprice * plan[i];
				int usemonth = dp[i - 1] + monthprice;
				dp[i] = Math.min(useday, usemonth);
				int usethreemonth = 0;
				if (i >= 3) {
					usethreemonth = dp[i - 3] + threemonthprice;
				} else {
					usethreemonth = threemonthprice;

				}
				dp[i] = Math.min(dp[i], usethreemonth);

				if (i == 12) {
					int useyear = yearprice;
					dp[i] = Math.min(dp[i], useyear);
				}

			}
			sb.append("#").append(tc).append(" ").append(dp[12]).append("\n");
		}
		System.out.println(sb);

	}

}
