package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1928 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1928.txt"));
		int tc = Integer.parseInt(br.readLine());
		String base64 ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		for (int i = 1; i <= tc; i++) {
			String input = br.readLine();
			String input_2 = ""; 
			for (int j = 0; j < input.length(); j++) {
				char ch = input.charAt(j);
				int value = base64.indexOf(ch);
				String binary = Integer.toBinaryString(value);
				while(binary.length()<6) {
					binary = "0"+binary;
				}
				input_2 +=binary;
			}
			String result = "";
			for (int j = 0; j < input_2.length(); j+=8) {
				String binary = input_2.substring(j,j+8);
				int value = Integer.parseInt(binary,2);
				result += (char) value;
			}
			System.out.printf("#%d %s\n",i,result);
		}
				
	
		

	}

}
