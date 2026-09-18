package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA5648_1 {
	static int N, energy;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void simulation(ArrayList<int[]> atoms) {
        while (atoms.size() >= 2) {
            ArrayList<int[]> moved = new ArrayList<>();

            HashMap<Integer, Integer> count = new HashMap<>();

            for (int[] atom : atoms) {

                int x = atom[0];
                int y = atom[1];
                int dir = atom[2];

                x += dx[dir];
                y += dy[dir];
                
                if (x < 0 || x > 4000 ||
                    y < 0 || y > 4000) {
                    continue;
                }

                atom[0] = x;
                atom[1] = y;

                moved.add(atom);

                int key = x * 4001 + y;

                count.put(
                    key,
                    count.getOrDefault(key, 0) + 1
                );
            }

            ArrayList<int[]> next = new ArrayList<>();

            for (int[] atom : moved) {

                int x = atom[0];
                int y = atom[1];

                int key = x * 4001 + y;

                if (count.get(key) >= 2) {
                    energy += atom[3];

                } else {
                    next.add(atom);
                }
            }
            atoms = next;
        }
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input/swea_5648.txt"));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ArrayList<int[]> atoms = new ArrayList<>();
			energy = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) * 2 + 2000;
				int y = Integer.parseInt(st.nextToken()) * 2 + 2000;
				int dir = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				atoms.add(new int[] {x,y,dir,power});

			}
			simulation(atoms);

			sb.append("#").append(tc).append(" ").append(energy).append("\n");

		}
		System.out.println(sb);

	}

}
