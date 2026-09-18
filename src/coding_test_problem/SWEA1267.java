package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1267 {
	static ArrayList<Integer>[] arr;
	static int[] indegrees;
	static int V,E;
	static StringBuilder sb;
	static void check() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= V; i++) {
			if(indegrees[i]==0) {
				q.offer(i);
			}
			
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur)
			.append(" ");
			
			for (Integer ele : arr[cur]) {
				indegrees[ele] --;
				if(indegrees[ele] == 0) {
					q.offer(ele);
				}
			}

			
			
		}
		
		
		
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1267.txt"));
		int n = 10;
		sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList[V+1];
			indegrees = new int[V+1];
			for (int i = 0; i < V+1; i++) {
				arr[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				indegrees[b]++;
			}
			
			sb.append("#")
			.append(tc).append(" ");
			
			check();

			sb.append("\n");
			
		}
		System.out.println(sb);

	
		

	}

}
