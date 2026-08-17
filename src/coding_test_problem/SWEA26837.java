package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA26837 {
//	static int check (String sub_data) {
//		int [] arr = new int [4];
//		for (int j = 0; j < sub_data.length(); j++) {
//			if(sub_data.charAt(j) == 'A') {
//				arr[0] ++;
//			}
//			else if (sub_data.charAt(j) == 'C') {
//				arr[1]++;
//			}
//			else if(sub_data.charAt(j) == 'T') {
//				arr[2] ++;
//			}
//			else {
//				arr[3]++;
//			}
//		}
//
//		if(arr[0] == arr[2] && arr[1] == arr[3]) {
//			return 1;
//		}
//		return 0;
//	}

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_26837.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int str_len = Integer.parseInt(st.nextToken());
			String data = st.nextToken();
			int result = 0;
			for (int i = 0; i < data.length(); i++) {
			    int a = 0;
			    int t = 0;
			    int c = 0;
			    int g = 0;
			    for (int j = i; j < data.length(); j++) {
			        char ch = data.charAt(j);
			        if (ch == 'A') a++;
			        else if (ch == 'T') t++;
			        else if (ch == 'C') c++;
			        else g++;
			        if (a == t && c == g) {
			            result++;
			        }
			    }
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");

 		}
		System.out.println(sb);

	
		

	}

}
