package algorithm.lanqiao.w5.d1.t2;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 100010;
    static int[] tr = new int[N];

    public static void main(String[] args) throws Exception {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        for (int i = 1; i <= n; i++) {
            int v = Reader.nextInt();
            add(i, v);
        }
        for (int i = 0; i < m; i++) {
            int k = Reader.nextInt();
            int a = Reader.nextInt();
            int b = Reader.nextInt();
            if (k == 0) {
                System.out.println(query(b) - query(a - 1));
            } else {
                add(a, b);
            }
        }
    }

    private static int lowbit(int x) {
        return x & -x;
    }

    private static int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tr[i];
        }
        return res;
    }

    private static void add(int x, int v) {
        for (int i = x; i < N; i += lowbit(i)) {
            tr[i] += v;
        }
    }

    static class Reader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");

        static String nextLine() throws IOException {// 读取下一行字符串
            return reader.readLine();
        }

        static String next() throws IOException {// 读取下一个字符串
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {// 读取下一个int型数值
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {// 读取下一个double型数值
            return Double.parseDouble(next());
        }
    }
}