package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1213 {


	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1213.txt"));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int tc_num = Integer.parseInt(br.readLine());
			String word = br.readLine();
			String sen = br.readLine();
			int result =0;
			for (int i = 0; i <= sen.length()-word.length(); i++) {
				String sub = sen.substring(i,i+word.length());
				if(sub.equals(word)) {
					result++;
				}
			}

			
			
			
			
			
			
			
			
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}

	
		System.out.println(sb);

	}

}
