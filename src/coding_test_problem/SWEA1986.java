package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1986 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1986.txt"));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			int result =0;
			for (int j = 1; j <=num ; j++) {
				if(j%2 ==0) {
					result -=j;
				}
				else {
					result +=j;
				}
			}
			System.out.printf("#%d %d",i+1,result);
			System.out.println();
		}

	
		

	}

}
