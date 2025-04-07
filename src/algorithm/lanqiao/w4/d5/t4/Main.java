package algorithm.lanqiao.w4.d5.t4;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 1010, MOD = 998244353;
    static int[][] arr = new int[N][N], rmax = new int[N][N], rmin = new int[N][N];
    static int n, m, A, B;
    static int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        n = Reader.nextInt();
        m = Reader.nextInt();
        A = Reader.nextInt();
        B = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Reader.nextInt();
            }
        }

        // 固定列，求横着的每一小段最大最小值。现在rmax[i][j]表示arr[i][j, j+B-1]中的最大值
        for (int i = 0; i < n; i++) {
            getMax(arr[i], rmax[i], m, B);
            getMin(arr[i], rmin[i], m, B);
        }

        long res = 0;
        // 现在求竖着，多个行中的最大最小值
        // a用做temp，b存放最大值，c存放最小值
        int[] a = new int[N], b = new int[N], c = new int[N];
        // i表示取横着的rmax[][B-1-i, i]这一段
        for (int i = B - 1; i < m; i++) {
            // 取rmax[j]
            for (int j = 0; j < n; j++) {
                a[j] = rmax[j][i];
            }
            // 求竖着的最大值
            getMax(a, b, n, A);

            for (int j = 0; j < n; j++) {
                a[j] = rmin[j][i];
            }
            getMin(a, c, n, A);

            // 最大值×最小值
            for (int j = A - 1; j < n; j++) {
                res = (res + (long) b[j] * c[j]) % MOD;
            }
        }
        System.out.println(res);
    }

    private static void getMax(int[] a, int[] b, int len, int k) {
        int hh = 0, tt = -1;
        for (int i = 0; i < len; i++) {
            // 队列不空且队首元素需要出队
            if (hh <= tt && q[hh] + k <= i) {
                hh++;
            }
            while (hh <= tt && a[q[tt]] <= a[i]) {
                // 求最大值，要维护单调递减队列
                tt--;
            }
            q[++tt] = i;
            // 记录当前最大值
            b[i] = a[q[hh]];
        }
    }

    private static void getMin(int[] a, int[] b, int len, int k) {
        int hh = 0, tt = -1;
        for (int i = 0; i < len; i++) {
            if (hh <= tt && q[hh] + k <= i) {
                hh++;
            }
            while (hh <= tt && a[q[tt]] >= a[i]) {
                // 维护单调递增队列
                tt--;
            }
            q[++tt] = i;
            b[i] = a[q[hh]];
        }
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
