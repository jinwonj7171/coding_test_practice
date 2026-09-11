package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA2026_1 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	// 0: 상, 1: 우, 2: 하, 3: 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 2단계 이동 우선순위
	// 좌 -> 하 -> 우 -> 상
	static int[] movePriority = { 3, 2, 1, 0 };

	static int bfsCount;

	// 모든 방향 다 탐색하기 때문에 방향 순서는 안중요
	static int[][] bfs(int sr, int sc) {
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { sr, sc });
		dist[sr][sc] = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}
				if (map[nr][nc] == 1) {
					continue;
				}
				if (dist[nr][nc] != -1) {
					continue;
				}
				dist[nr][nc] = dist[r][c] + 1;
				queue.offer(new int[] { nr, nc });
			}

		}

		return dist;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int inputDir = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		int seaCount = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					seaCount++;
				}
			}
		}
//            1이 상, 2가 하, 3이 좌, 4가 우
		int[] convert = { 0, 0, 2, 3, 1 };
		int dir = convert[inputDir];
		List<int[]> answer = new ArrayList<>();
		visited[r][c] = true;
		answer.add(new int[] { r, c });
		while (answer.size() < seaCount) {
			// 1단계 인접한 미방문 바다 탐험
			while (true) {
				// 방향 재설정
				int[] order = { dir, (dir + 3) % 4, (dir + 1) % 4, (dir + 2) % 4 };
				boolean moved = false;
				for (int nd : order) {
					int nr = r + dr[nd];
					int nc = c + dc[nd];
					// 헤엄 불가 영역 제외
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
						continue;
					}
					if (map[nr][nc] == 1) {
						continue;
					}
					if (visited[nr][nc]) {
						continue;
					}
					r = nr;
					c = nc;
					dir = nd;
					// 이동 절차 대로 추가
					visited[r][c] = true;
					answer.add(new int[] { r, c });
					moved = true;
					break;

				}
				// 인접한 미방문 바다 없음
				if (!moved) {
					break;
				}
				// 헤엄 가능한 영역 모두 탐사 완료
				if (answer.size() == seaCount) {
					break;
				}
			}
			// 그 다음 단계 실행할 필요 없기에 바깥 while문 종료
			if (answer.size() == seaCount) {
				break;
			}
			// 2단계 가장 가까운 미방문 바다 찾기
			int[][] dist = bfs(r, c);
			int minDist = Integer.MAX_VALUE;
			int tr = -1;
			int tc = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 0 && !visited[i][j]) {
						if(dist[i][j] < minDist) {
							minDist = dist[i][j];
							tr = i;
							tc =j;
						}
					}
				}
			}
			int [][] distToTarget = bfs(tr,tc);
			while(r!=tr || c != tc) {
				for(int nd: movePriority) {
					int nr = r + dr[nd];
					int nc = c + dc[nd];
					if(nr < 0 || nr >=N || nc<0 || nc>=N) {
						continue;
					}
					if(map[nr][nc] ==1) {
						continue;
					}
					if(distToTarget[nr][nc] == distToTarget[r][c] -1) {
						r = nr;
						c = nc;
						dir = nd;
						break;
					}
				}

			}
			visited[r][c] = true;
			answer.add(new int[] {r,c});

		}
		StringBuilder sb = new StringBuilder();
		for (int[] pos : answer) {
			sb.append(pos[0]+1)
			.append(" ")
			.append(pos[1]+1)
			.append("\n");
		}
		System.out.println(sb);

	}
}