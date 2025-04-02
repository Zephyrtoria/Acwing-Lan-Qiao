package algorithm.lanqiao.w1.d2.t5;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 510;
    static int[][] s = new int[N][N];
    static int n, m, k;

    public static void main(String[] args) throws Exception {
        n = Reader.nextInt();
        m = Reader.nextInt();
        k = Reader.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = Reader.nextInt();
                // 只需要处理列的前缀和
                s[i][j] += s[i - 1][j];
            }
        }

        // 固定上下边界
        long res = 0;
        for (int h = 1; h <= n; h++) {
            for (int d = h; d <= n; d++) {
                // 固定右边界
                // 双指针：根据右边界确定左边界，使得区间和小于等于k
                for (int l = 1, r = 1, sum = 0; r <= m; r++) {
                    sum += s[d][r] - s[h - 1][r];
                    while (sum > k) {
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

        public static String nextLine() throws Exception {
            return br.readLine();
        }

        public static String next() throws Exception {
            while (!tk.hasMoreTokens()) {
                tk = new StringTokenizer(nextLine());
            }
            return tk.nextToken();
        }

        public static int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
