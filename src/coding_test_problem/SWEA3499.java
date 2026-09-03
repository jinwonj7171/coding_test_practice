package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA3499 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_3499.txt"));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= n; tc++) {
			int num = Integer.parseInt(br.readLine());
			int first_index = (num % 2 == 1) ? num / 2 + 1 : num / 2;
			String[] first = new String[first_index];
			String[] second = new String[num / 2];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < first_index; i++) {
				first[i] = st.nextToken();
			}
			for (int i = 0; i < num / 2; i++) {
				second[i] = st.nextToken();
			}
			String[] result = new String[num];
			int result_index = 0;
			for (int i = 0; i < first.length; i++) {
				result[result_index++] = first[i];
				if (i == second.length) {
					break;
				}
				result[result_index++] = second[i];
			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}

}
