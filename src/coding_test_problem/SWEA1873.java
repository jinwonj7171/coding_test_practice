package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1873 {
	static char[][] arr;
	static char[] comm;
	static int H;
	static int W;
	static int[] dc = { -1, 1, 0, 0 };
	static int[] dr = { 0, 0, -1, 1 };
	static int nx;
	static int ny;

	static boolean check(int x, int y) {
		if (x >= 0 && y >= 0 && x < H && y < W) {
			return true;
		}
		return false;
	}

	static void shooting(char dir, int x, int y) {
		switch (dir) {
		case '<':
			for (int i = y - 1; i >= 0; i--) {
				if (arr[x][i] == '*') {
					arr[x][i] = '.';
					break;
				} else if (arr[x][i] == '#') {
					break;
				}
			}
			break;
		case '>':
			for (int i = y + 1; i < W; i++) {
				if (arr[x][i] == '*') {
					arr[x][i] = '.';
					break;
				} else if (arr[x][i] == '#') {
					break;
				}
			}
			break;
		case '^':
			for (int i = x - 1; i >= 0; i--) {
				if (arr[i][y] == '*') {
					arr[i][y] = '.';
					break;
				} else if (arr[i][y] == '#') {
					break;
				}
			}
			break;
		case 'v':
			for (int i = x + 1; i < H; i++) {
				if (arr[i][y] == '*') {
					arr[i][y] = '.';
					break;
				} else if (arr[i][y] == '#') {
					break;
				}
			}
			break;

		}
	}

	static void action(int x, int y) {
		for (int i = 0; i < comm.length; i++) {
			char input = comm[i];
			switch (input) {
			case 'U':
				nx = x + dc[0];
				ny = y + dr[0];
				if (check(nx, ny) && (arr[nx][ny] == '.')) {
					arr[x][y] = '.';
					x = nx;
					y = ny;
					arr[x][y] = '^';
				} else {
					arr[x][y] = '^';
				}
				break;
			case 'D':
				nx = x + dc[1];
				ny = y + dr[1];
				if (check(nx, ny) && (arr[nx][ny] == '.')) {
					arr[x][y] = '.';
					x = nx;
					y = ny;
					arr[x][y] = 'v';
				} else {
					arr[x][y] = 'v';
				}
				break;
			case 'L':
				nx = x + dc[2];
				ny = y + dr[2];
				if (check(nx, ny) && (arr[nx][ny] == '.')) {
					arr[x][y] = '.';
					x = nx;
					y = ny;
					arr[x][y] = '<';
				} else {
					arr[x][y] = '<';
				}
				break;
			case 'R':
				nx = x + dc[3];
				ny = y + dr[3];
				if (check(nx, ny) && (arr[nx][ny] == '.')) {
					arr[x][y] = '.';
					x = nx;
					y = ny;
					arr[x][y] = '>';
				} else {
					arr[x][y] = '>';
				}
				break;
			case 'S':
				char shoot_dir = arr[x][y];
				shooting(shoot_dir, x, y);
				break;
			default:
				break;

			}

		}
//		for (int j = 0; j < H; j++) {
//			System.out.println(arr[j]);
//		}
//		System.out.println("-----------------------------------------");

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1873.txt"));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char[H][W];
			int start_x = -1;
			int start_y = -1;
			for (int i = 0; i < H; i++) {
				String stage = br.readLine();
				for (int j = 0; j < W; j++) {
					char stage_ch = stage.charAt(j);

					arr[i][j] = stage_ch;
					if (stage_ch == '^' || stage_ch == '>' || stage_ch == '<' || stage_ch == 'v') {
						start_x = i;
						start_y = j;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			comm = new char[N];
			String com = br.readLine();
			for (int i = 0; i < N; i++) {
				comm[i] = com.charAt(i);
			}
			action(start_x, start_y);

			sb.append("#").append(tc).append(" ");

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");

			}

		}
		System.out.println(sb);

	}

}
