package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1251 {
	static int[] arrx;
	static int[] arry;

	static long check(int[] arrx, int[] arry, int num) {
		// visited, minDist 생성 및 초기화
		boolean[] visited = new boolean[num];
		long[] minDist = new long[num];
		Arrays.fill(minDist, Long.MAX_VALUE);
		minDist[0] = 0;
		long total = 0;
		// 아직 방문하지 않은 섬 중 가장 가까운 섬 선택
		for (int i = 0; i < num; i++) {
			int minIdx = -1;
			long min = Long.MAX_VALUE;
			for (int j = 0; j < num; j++) {
				if (!visited[j] && minDist[j] < min) {
					min = minDist[j];
					minIdx = j;
				}
			}
			visited[minIdx] = true;
			total += min;
			// 새로 선택한 섬을 기준으로 거리 갱신
			for (int j = 0; j < num; j++) {
				if (!visited[j]) {
					long dx = arrx[minIdx] - arrx[j];
					long dy = arry[minIdx] - arry[j];
					long dist = dx * dx + dy * dy;
					if (dist < minDist[j]) {
						minDist[j] = dist;
					}
				}
			}

		}

		return total;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1251.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			arrx = new int[num];
			for (int i = 0; i < num; i++) {
				arrx[i] = Integer.parseInt(st1.nextToken());
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			arry = new int[num];
			for (int i = 0; i < num; i++) {
				arry[i] = Integer.parseInt(st2.nextToken());
			}
			double E = Double.parseDouble(br.readLine());

			long totalDistance = check(arrx, arry, num);
			long result = Math.round(E * totalDistance);

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}

		System.out.println(sb);

	}

}
