package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1767 {
    static int N;
    static int[][] arr;
    static List<int[]> cores;

    static int maxCore;    
    static int minLength;  


    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static boolean check(int r, int c, int dir) {
    	int nr = r + dr[dir];
    	int nc = c + dc[dir];
    	while(nr>=0&&nr<N&&nc>=0&&nc<N) {
    		if(arr[nr][nc] !=0) {
    			return false;
    		}
    		nr +=dr[dir];
    		nc += dc[dir];
    	}
    	return true;
    }
    static int setLine(int r, int c, int dir, int value) {
    	int nr = r + dr[dir];
    	int nc = c + dc[dir];
    	int length = 0;
    	while(nr>=0&&nr<N&&nc>=0&&nc<N) {
    		arr[nr][nc] =value;
    		length ++;
    		nr +=dr[dir];
    		nc +=dc[dir];
    	}
    	return length;
    	
    	
    	
    }
    static void dfs(int idx, int coreCnt,int lineCnt) {
    	if(idx == cores.size()) {
    		if(coreCnt > maxCore) {
    			maxCore = coreCnt;
    			minLength = lineCnt;
    		}
    		else if (coreCnt == maxCore) {
    			minLength = Math.min(minLength, lineCnt);
    			
    		}
    		return;
    	}
    	int r = cores.get(idx)[0];
    	int c = cores.get(idx)[1];
    	for(int dir =0; dir <4;dir++) {
    		if(check(r,c,dir)) {
    			int length = setLine(r,c,dir,2);
    			dfs(
    					idx+1,coreCnt+1,lineCnt+length);
    			setLine(r,c,dir,0);
    		}
    	}
    	dfs(idx +1,coreCnt,lineCnt);
    	
    	
    	
    }
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1767.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int [N][N];
			cores = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] ==1) {
                        if (i != 0 &&
                                i != N - 1 &&
                                j != 0 &&
                                j != N - 1) {

                                cores.add(new int[]{i, j});
                            }
					}
				}
			}
			maxCore = 0;
			minLength = Integer.MAX_VALUE;
			dfs(0,0,0);
			sb.append("#").append(tc).append(" ").append(minLength).append("\n");
		}

	
		
		System.out.println(sb);
	}
	

}
