package coding_test_problem;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class SWEA3260 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_3260.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			BigInteger a = new BigInteger(st.nextToken());
			BigInteger b = new BigInteger(st.nextToken());
			BigInteger result = a.add(b);
			
			
			
			
			sb.append("#")
			.append(tc)
			.append(" ")
			.append(result)
			.append("\n");
		}
		System.out.println(sb);

	
		

	}

}
