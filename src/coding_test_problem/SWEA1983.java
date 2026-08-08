package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1983 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1983.txt"));
		int tc = Integer.parseInt(br.readLine());
		String [] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			double [] temp = new double [N];
			for (int j = 0; j < N; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
				double total_num = 0;
				double[] scoring = {0.35,0.45,0.2};
				for (int t = 0; t < 3; t++) {
					total_num += Integer.parseInt(st2.nextToken())*scoring[t];
				}
				temp[j] = total_num;
				
			}
			int limit = N/10;
			Double K_score = temp[K-1];
			System.out.println(Arrays.toString(temp));
			Arrays.sort(temp);
			int K_index =0;
			System.out.println(K);
			System.out.println(K_score);
			System.out.println(Arrays.toString(temp));
			for (int j = 0; j < temp.length; j++) {
				if(temp[j] == K_score) {
					K_index = j;
					break;
				}
			}
			System.out.println(K_index);
			String [] result = new String [N];
			int index = 0;
			for (int j = 9; j >=0; j--) {
				for (int t = 0; t < limit; t++) {
					result[index++] = grade[j];
				}
			}
			System.out.println(Arrays.toString(result));
			System.out.printf("#%d %s\n",i,result[K_index]);
			
			
		}
			
	
		

	}

}
