package coding_test_problem;


import java.io.*;
import java.util.*;

public class SWEA1861_2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new FileReader("input/swea_1861.txt")
        );

        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {

            int N = Integer.parseInt(br.readLine());

            // room 번호 → 위치
            int[][] pos = new int[N * N + 1][2];

            for (int r = 0; r < N; r++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {

                    int num = Integer.parseInt(st.nextToken());

                    pos[num][0] = r;
                    pos[num][1] = c;
                }
            }

            int start = 1;
            int maxCnt = 1;

            int currentStart = 1;
            int cnt = 1;

            for (int num = 1; num < N * N; num++) {

                int r1 = pos[num][0];
                int c1 = pos[num][1];

                int r2 = pos[num + 1][0];
                int c2 = pos[num + 1][1];

                // num과 num+1이 상하좌우로 붙어 있는지
                if (Math.abs(r1 - r2) + Math.abs(c1 - c2) == 1) {

                    cnt++;

                } else {

                    if (cnt > maxCnt) {
                        maxCnt = cnt;
                        start = currentStart;
                    }

                    currentStart = num + 1;
                    cnt = 1;
                }
            }

            // 마지막 구간 처리
            if (cnt > maxCnt) {
                maxCnt = cnt;
                start = currentStart;
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(start)
              .append(" ")
              .append(maxCnt)
              .append("\n");
        }

        System.out.println(sb);
    }
}