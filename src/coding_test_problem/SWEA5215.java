package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA5215 {
	static int[] prefs;
	static int[] cals;
	static int limit;

	static int max_pref;
	static int num;

	static void dfs(int idx, int pref, int cal) {
		if (cal > limit) {
			return;
		}
		if (idx == num) {
			max_pref = Math.max(max_pref, pref);
			return;
		}

		dfs(idx + 1, pref + prefs[idx], cal + cals[idx]);
		dfs(idx + 1, pref, cal);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_5215.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			prefs = new int[num];
			cals = new int[num];

			for (int i = 0; i < num; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				prefs[i] = a;
				cals[i] = b;
			}

			max_pref = 0;
			dfs(0, 0, 0);

			sb.append("#").append(tc).append(" ").append(max_pref).append("\n");
		}
		System.out.println(sb);

	}

}
