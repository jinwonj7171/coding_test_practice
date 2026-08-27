package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1218 {
	static Deque<Character> stack = new ArrayDeque<>();

	static char pair(char c) {
		switch (c) {
		case ')':
			return '(';
		case ']':
			return '[';
		case '}':
			return '{';
		case '>':
			return '<';
		default:
			return ' ';
		}
	}

	static boolean check(char ch) {
		if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
			stack.push(ch);
		} else {
			if (stack.isEmpty()) {
				return false;
			}
			if (stack.peek() == pair(ch)) {
				stack.pop();
			} else {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1218.txt"));
		StringBuilder sb = new StringBuilder();
		int n = 10;
		for (int tc = 1; tc <= n; tc++) {
			int num = Integer.parseInt(br.readLine());
			String data = br.readLine();
			char[] arr = data.toCharArray();
			stack = new ArrayDeque<>();
			int result = 1;
			for (int i = 0; i < arr.length; i++) {
				boolean stop = check(arr[i]);
				if (!stop) {
					result = 0;
					break;
				}
			}
			if (!stack.isEmpty()) {
			    result = 0;
			}

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}
