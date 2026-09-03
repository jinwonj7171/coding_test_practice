package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1233 {

	static char[] operators = { '+', '-', '*', '/' };

	static boolean isOperator(String value) {
		for (char op : operators) {
			if (value.charAt(0) == op) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader("input/swea_1233.txt"));

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {

			int num = Integer.parseInt(br.readLine());

			boolean valid = true;

			for (int i = 0; i < num; i++) {

				StringTokenizer st = new StringTokenizer(br.readLine());

				int cnt = st.countTokens();

				st.nextToken();
				String value = st.nextToken();

				if (cnt == 4) {

					if (!isOperator(value)) {
						valid = false;
					}

				} else if (cnt == 2) {

					if (isOperator(value)) {
						valid = false;
					}

				} else {

					valid = false;
				}
			}

			sb.append("#").append(tc).append(" ").append(valid ? 1 : 0).append("\n");
		}

		System.out.println(sb);
	}
}