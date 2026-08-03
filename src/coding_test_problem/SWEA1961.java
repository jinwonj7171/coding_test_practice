package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1961 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1961.txt"));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			int [][] input = new int[num][num];
			for (int j = 0; j < num; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int k = 0; k < num; k++) {
					input[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.printf("#%d",i+1);
			System.out.println();
			String [] temp = new String[num];
			int index =0;
			for (int j = 0; j < num; j++) {
				temp[index] = "";
				for (int k = num-1; k >=0; k--) {
					temp[index] += String.valueOf(input[k][j]);
				}
				index++;
				
			}
			index =0;
			for (int j = num-1; j >=0; j--) {
				temp[index] += " ";
				for (int k = num-1; k >=0; k--) {
					temp[index] += String.valueOf(input[j][k]);
				}
				index++;
				
			}
			index =0;
			for (int j = num-1; j >=0; j--) {
				temp[index] += " ";
				for (int k = 0; k <num; k++) {
					temp[index] += String.valueOf(input[k][j]);
				}
				index++;
				
			}
			for (int j = 0; j < num; j++) {
				System.out.println(temp[j]);
			}
			
			
		}

	}

}
