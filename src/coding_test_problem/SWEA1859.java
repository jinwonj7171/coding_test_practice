package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1859 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1859.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc =1; tc<=T; tc++) {
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr = new int[cnt];
			for (int i=0;i<cnt;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
//			int money =0;
//			int buy =0;
//			int max_val = 0;
//			int earn = 0;
//			for (int i=0;i<cnt;i++) {
//				max_val = Math.max(max_val, arr[i]);
//			}
//			for (int i=0;i<cnt;i++) {
//				if (arr[i] != max_val) {
//					buy +=1;
//					money +=arr[i];
//				}
//				else {
//					earn += max_val*buy - money;
//					money =0;
//					buy =0;
//					max_val =0;
//					for (int j=i+1;j<cnt;j++) {
//						max_val = Math.max(max_val, arr[j]);
//					}
//					
//				}
//			}
			long money =0;
			
			int max_val = arr[cnt-1];
			for (int i=cnt-2;i>=0;i--) {
				if (arr[i] > max_val){
					max_val = arr[i];
				}
				else {
					money += max_val - arr[i];
				}
				
			}
			
			sb.append("#")
			.append(tc)
			.append(" ")
			.append(money)
			.append("\n")
			;
			
			
		}
		System.out.print(sb);

	}

}
