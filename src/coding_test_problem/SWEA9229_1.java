package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA9229_1 {
	static int limit_weight;
	static int max_weight;
	static final int limit_count =2;
	static void dfs(List<Integer> arr, int weight,int count) {
		if(max_weight<weight && weight<=limit_weight && count==limit_count ) {
			max_weight = weight;
		}
		else if(weight>limit_weight || count >limit_count) {
			return;
		}
		int size = arr.size();
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> arr2 = new ArrayList<>(arr);
			arr2.remove(i);
			dfs(arr2,weight+arr.get(i),count+1);
		}
	}

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_9229.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			limit_weight = Integer.parseInt(st.nextToken());
			List<Integer> arr = new ArrayList<>();
		
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			
			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(st2.nextToken()));
			}
			max_weight =-1;
			int weight = 0;
			int count =0;
			dfs(arr,weight,count);
			sb.append("#")
			.append(tc)
			.append(" ")
			.append(max_weight)
			.append("\n");
		}
		System.out.println(sb);

	
		

	}

}
