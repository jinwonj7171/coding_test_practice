package coding_test_problem;

import java.io.*;
import java.util.*;

public class Ad09 {
	static int N;
	static int[][] arr;
	static ArrayList<int[]> data;

	static void make(int r, int c, int len, int home) {
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j < 31; j++) {
				int way = Math.abs(r - i) + Math.abs(c - j);
				if (way == 0) {
					arr[i][j] = -1;
				}
				if (way <= len && arr[i][j] != -1) {
					arr[i][j] |= (1 << home);
				}
			}
		}
	}

	static int cal(int r, int c, int tr, int tc) {
		return Math.abs(r - tr) + Math.abs(c - tc);
	}

	static int checking() {
		int min_result = Integer.MAX_VALUE;
		// flag 1
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j < 31; j++) {
				if (arr[i][j] <= 0)
					continue;

				boolean possible = true;

				for (int t = 1; t <= N; t++) {
					if ((arr[i][j] & (1 << t)) == 0) {
						possible = false;
						break;
					}
				}
				if (possible) {
					min_result = Math.min(min_result, check(i, j, -1, -1));
				}
			}
		}
		if (min_result != Integer.MAX_VALUE) {
			return min_result;
		}
		// flag 2
		min_result = Integer.MAX_VALUE;
		List<int[]> plus = new ArrayList<>();
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j < 31; j++) {
				if (arr[i][j] <= 0)
					continue;
				plus.add(new int[] { i, j });
			}

		}

		for (int i = 0; i < plus.size() - 1; i++) {
			int[] A = plus.get(i);
			for (int j = i + 1; j < plus.size(); j++) {
				int[] B = plus.get(j);
				int mask = arr[A[0]][A[1]] | arr[B[0]][B[1]];
				boolean possible = true;

				for (int t = 1; t <= N; t++) {
					if ((mask & (1 << t)) == 0) {
						possible = false;
						break;
					}
				}
				if (possible) {
					int result = check(A[0], A[1], B[0], B[1]);
					min_result = Math.min(min_result, result);
				}

			}

		}

		if (min_result != Integer.MAX_VALUE) {
			return min_result;
		}
		return -1;

	}

	static int check(int r, int c, int nr, int nc) {
		int[] check = new int[N + 1];
		Arrays.fill(check, Integer.MAX_VALUE);
		if (nr == -1) {
			for (int t = 1; t <= N; t++) {
				if ((arr[r][c] & (1 << t)) != 0) {
					int leng = cal(r, c, data.get(t)[0], data.get(t)[1]);
					if (check[t] > leng) {
						check[t] = leng;
					}

				}
			}

		} else {
			for (int t = 1; t <= N; t++) {
				if ((arr[r][c] & (1 << t)) != 0) {
					int leng = cal(r, c, data.get(t)[0], data.get(t)[1]);
					if (check[t] > leng) {
						check[t] = leng;
					}
				}
			}
			for (int t = 1; t <= N; t++) {
				if ((arr[nr][nc] & (1 << t)) != 0) {
					int leng = cal(nr, nc, data.get(t)[0], data.get(t)[1]);
					if (check[t] > leng) {
						check[t] = leng;
					}
				}
			}
		}

		int result = 0;
		for (int i = 1; i < N + 1; i++) {
			result += check[i];
		}
		return result;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/ad_09.txt"));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[31][31];
			data = new ArrayList<>();
			data.add(new int[] { 0, 0 });
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken()) + 15;
				int c = Integer.parseInt(st.nextToken()) + 15;
				int len = Integer.parseInt(st.nextToken());
				make(r, c, len, i);
				data.add(new int[] { r, c });

			}
			int result = checking();

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}
//2 3 36 -1 21
