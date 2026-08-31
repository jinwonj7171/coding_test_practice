package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1225 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1225.txt"));
		StringBuilder sb= new StringBuilder();
		int n =10;
		for (int tc = 1; tc <= n; tc++) {
			int num1 = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Deque<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				int ele = Integer.parseInt(st.nextToken());
				q.offer(ele);
			}
			int num =1;
			int temp=1;
			while(temp !=0) {
//				System.out.println(q);
				temp = q.pop();
				temp -=num;
				if(temp<=0) {
					temp = 0;
				}
				q.offer(temp);
				num++;
				if (num>5) {
					num=1;
				}
			}
		
			String result = "";
			int size = q.size();
			for (int i = 0; i < size; i++) {
				result += q.pop().toString();
				result +=" ";
			}
			
			sb.append("#")
			.append(tc)
			.append(" ")
			.append(result)
			.append("\n");
			
			
		}

	System.out.println(sb);
		

	}

}
