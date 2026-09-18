package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA6782 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_6782.txt"));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			long num = Long.parseLong(br.readLine());
			long count = 0;
			while (num != 2) {
				long root = (long) Math.sqrt(num);
				if (root * root < num) {
					root++;
				}
				count += root * root - num;
				count++;
				num = root;
			}

			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);

	}

}
