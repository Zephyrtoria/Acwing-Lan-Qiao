package algorithm.lanqiao.w2.d2.t6;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 510;
    static int[][] s = new int[N][N];
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        n = Reader.nextInt();
        m = Reader.nextInt();
        k = Reader.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = Reader.nextInt();
                // 仅算每一列的前缀和
                s[i][j] += s[i - 1][j];
            }
        }

        long res = 0;
        for (int h = 1; h <= n; h++) {
            for (int d = h; d <= n; d++) {
                int sum = 0;
                for (int l = 1, r = 1; r <= m; r++) {
                    sum += s[d][r] - s[h - 1][r];
                    while (l <= r && sum > k) {
                        sum -= s[d][l] - s[h - 1][l];
                        l++;
                    }
                    res += r - l + 1;
                }
            }
        }
        System.out.println(res);
    }

    static class Reader {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tk = new StringTokenizer("");

        public static String nextLine() throws IOException {
            return br.readLine();
        }

        public static String next() throws IOException {
            while (!tk.hasMoreTokens()) {
                tk = new StringTokenizer(nextLine());
            }
            return tk.nextToken();
        }

        public static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

    }
}
