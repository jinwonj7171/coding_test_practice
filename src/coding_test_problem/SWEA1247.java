package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1247 {
	static int N;
	static int[] co, my;
	static ArrayList<int[]> data;
	static boolean[] visited;
	static int min;

	static int cal(int r, int c, int nr, int nc) {
		return Math.abs(nr - r) + Math.abs(nc - c);
	}

	static void check(int r, int c, int idx, int len) {
		if (len >= min) {
			return;
		}
		if (idx == N) {
			len += cal(r, c, my[0], my[1]);
			min = Math.min(min, len);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			int dist = cal(r, c, data.get(i)[0], data.get(i)[1]);
			check(data.get(i)[0], data.get(i)[1], idx + 1, len + dist);
			visited[i] = false;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1247.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			int cor = Integer.parseInt(st.nextToken());
			int coc = Integer.parseInt(st.nextToken());
			co = new int[] { cor, coc };
			int myr = Integer.parseInt(st.nextToken());
			int myc = Integer.parseInt(st.nextToken());
			my = new int[] { myr, myc };
			data = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int cur = Integer.parseInt(st.nextToken());
				int cuc = Integer.parseInt(st.nextToken());
				data.add(new int[] { cur, cuc });
			}
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			check(co[0], co[1], 0, 0);

			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);

	}

}
