package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1989 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1989.txt"));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= tc; i++) {
			String data = br.readLine();
//			System.out.println(data);
			String temp1 ="";
			String temp2 ="";
			int index=0;
			for (int j = data.length()-1; j >=0; j--) {
				temp1+=data.charAt(j);
				temp2+=data.charAt(index++);
				if(j == data.length()/2) {
					break;
				}

			}
			if(temp1.equals(temp2)) {
				sb.append("#").append(i).append(" ").append(1).append("\n");
				
			}
			else {
				sb.append("#").append(i).append(" ").append(0).append("\n");
			}
			
		}
		System.out.print(sb);
	
		

	}

}
