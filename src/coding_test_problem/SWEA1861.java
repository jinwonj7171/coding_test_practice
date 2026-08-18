package coding_test_problem;


// 외길이니까 BFS,DFS 쓰지 않는다. visited 배열 쓰지 않는다.
// 메모이제이션
import java.io.*;
import java.util.*;

public class SWEA1861 {
	
	
	private static int[][] A;


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1861.txt"));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; testcase++) {
			N = Integer.parseInt(br.readLine()); //1~1000
			A = new int[N][N];
			for (int i = 0; i < A.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < A.length; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxCnt =0; //최대 이동할 수 있는 방의 개수
			int index = Integer.MAX_VALUE; //최대 이동을 위해 출발할 방위치 (숫자) (작은 수를 찾음)
			// 모든 정점에서 출발해서, 갈수 있는 칸으로 탐색
			for (int r = 0; r < A.length; r++) {
				for (int c = 0; c < A.length; c++) {
					int cnt = go(r,c);// (r,c) 에서 출발해서 이동 가능한 칸수
					// 이동가능 칸수의 최대값
					if(maxCnt < cnt || (maxCnt == cnt && index > A[r][c])) {
						maxCnt = cnt;
						index = A[r][c];
					}
				}
			}
			sb.append("#").append(testcase).append(" ").append(index).append(" ").append(maxCnt).append("\n");
		}
		System.out.println(sb.toString());
		
		
		
	} // end of main
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int N;
	
	
	// A[r][c]에서 출발해서 최대 이동할 수 있는 방의 개수를 리턴하는 메서드
	private static int go(int r, int c) {
		int cnt =1; // r,c에서 이동할 수 있는 방 개수
		// 현재칸 r,c 에서 인접칸 상하좌우 나보다 1큰수 방 가기
		while(true ) {
			int nextNum = A[r][c] +1;
			boolean moved = false;
			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(0<=nr && nr<N && 0<=nc && nc<N && nextNum == A[nr][nc]) {
					r = nr;
					c = nc;
					cnt++;
	                moved = true;
	                break;

				}
				
			}
	        if (!moved) {
	            break;
	        }
			
		}
		return cnt;

		
		
		
		
		
		
		
		
		
	}
}// end of class
