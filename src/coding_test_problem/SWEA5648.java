package coding_test_problem;

import java.io.*;
import java.util.*;


public class SWEA5648 {
	static int N;
	static Atom[] list;

	private static int makeBoomPair() {
		Arrays.sort(list);
		ArrayList<Pair> boomPairs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				Atom a = list[i], b = list[j];
				// 수직에서 만날때 (x 좌표가 같다)
				if (a.x == b.x) {
					if (a.dir == 0 && b.dir == 1)
						boomPairs.add(new Pair(i, j, Math.abs(b.y - a.y) / 2));
				}

				// 수평에서 만날때
				if (a.y == b.y) {
					if (a.dir == 3 && b.dir == 2)
						boomPairs.add(new Pair(i, j, Math.abs(a.x - b.x) / 2));
				}

				// / 대각라인 원자들이 만날때
				if (a.x - a.y == b.x - b.y) {
					if (a.dir == 3 && b.dir == 1 || a.dir == 0 && b.dir == 2)
						boomPairs.add(new Pair(i, j, Math.abs(a.x - b.x)));
				}

				// \ 대각라인 원자들이 만날때
				if (a.x + a.y == b.x + b.y) {
					if (a.dir == 1 && b.dir == 2 || a.dir == 3 && b.dir == 0)
						boomPairs.add(new Pair(i, j, Math.abs(a.x - b.x)));
				}
			}
		}
		return getTotalEnergy(boomPairs);
	}

	private static int getTotalEnergy(ArrayList<Pair> boomPairs) {
		Collections.sort(boomPairs, (a, b) -> a.time <= b.time ? -1 : 1); // 소멸되는 시간에 따라 정렬
		int sum = 0;

		final int INF = Integer.MAX_VALUE;
		int boomTimes[] = new int[N]; // 각 원자들이 폭발하는 가장 빠른 시간 기록
		Arrays.fill(boomTimes, INF); // 최대값으로 초기화

		for (Pair p : boomPairs) {
			if (boomTimes[p.i] < p.time || boomTimes[p.j] < p.time)
				continue;
			// 여러개 충돌 경우 조합으로 처리
			if (boomTimes[p.i] == INF) { // 안터졌다면
				boomTimes[p.i] = p.time;
				sum += list[p.i].e;
			}
			if (boomTimes[p.j] == INF) { // 안터졌다면
				boomTimes[p.j] = p.time;
				sum += list[p.j].e;
			}

		}
		return sum;
	}

	static class Atom implements Comparable<Atom> {
		int x, y, dir, e;

		public Atom(int x, int y, int dir, int e) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}

		@Override
		public int compareTo(Atom o) {
			int diff = Integer.compare(this.x, o.x);
			return diff != 0 ? diff : Integer.compare(this.y, o.y);
		}
	}

	static class Pair {
		int i, j;
		int time;

		public Pair(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_5648.txt"));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			list = new Atom[N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				// 만약 시간을 정수로 처리하고 싶으면 *2배 처리
				int x = Integer.parseInt(st.nextToken()) * 2; // x좌표
				int y = Integer.parseInt(st.nextToken()) * 2; // y좌표
				int d = Integer.parseInt(st.nextToken()); // 방향
				int e = Integer.parseInt(st.nextToken()); // 에너지

				list[i] = new Atom(x, y, d, e);
			}

			sb.append("#").append(tc).append(" ").append(makeBoomPair()).append("\n");

		}
		System.out.println(sb);

	}

}
