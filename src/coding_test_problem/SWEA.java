package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_.txt"));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			
			
			sb.append("#")
			.append(tc)
			.append(" ")
			.append(false)
			.append("\n");
		}
		System.out.println(sb);

	
		

	}

}
