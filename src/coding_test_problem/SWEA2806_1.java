package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA2806_1 {
	static int[][] arr;
	static int [] dr = {-1,-1,-1};
	static int [] dc = {-1,0,1};
	static int N;
	static int count;
    static boolean check(int r, int c) {
    	for (int dir = 0; dir < 3; dir++) {
        	int nr = r + dr[dir];
        	int nc = c + dc[dir];
        	while(nr>=0&&nr<N&&nc>=0&&nc<N) {
        		if(arr[nr][nc] ==1) {
        			return false;
        		}
        		nr +=dr[dir];
        		nc += dc[dir];
        	}
        	
		}

    	return true;
    }
    static void dfs (int r) {
    	if(r == N) {
    		count ++;
    		return;
    	}
    	for (int i = 0; i < N; i++) {
			if (check(r,i)) {
				arr[r][i] =1;
				dfs(r+1);
				arr[r][i] = 0;
			}
		}
    }
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_2806.txt"));
		int n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= n; tc++) {
			count=0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			dfs(0);
			System.out.println("#" + tc + " " + count);
				
			}
			
		}

	
		

	

}
