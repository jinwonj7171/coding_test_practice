package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA1244 {

    static int max;
    static Set<String>[] visited;

    static void dfs(char[] arr, int count, int step) {

        if (count == step) {
            int num = Integer.parseInt(new String(arr));
            max = Math.max(max, num);
            return;
        }

        String current = new String(arr);

        if (visited[count].contains(current)) {
            return;
        }

        visited[count].add(current);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                dfs(arr, count + 1, step);
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new FileReader("input/swea_1244.txt"));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String num = st.nextToken();
            int step = Integer.parseInt(st.nextToken());

            max = 0;

            visited = new HashSet[step + 1];

            for (int i = 0; i <= step; i++) {
                visited[i] = new HashSet<>();
            }

            char[] arr = num.toCharArray();

            dfs(arr, 0, step);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(max)
              .append("\n");
        }

        System.out.print(sb);
    }
}