package algorithm.lanqiao.w5.d1.t1;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 15010;
    static final int M = 32010;
    static int n;
    // 树状数组
    static int[] tr = new int[M];
    // 结果集合
    static int[] level = new int[N];

    public static void main(String[] args) throws Exception {
        n = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            int x = Reader.nextInt();
            int y = Reader.nextInt();
            // 树状数组下标要从1开始
            x++;
            int t = query(x);
            level[t]++;
            add(x, 1);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(level[i]);
        }
    }

    // 树状数组
    private static int lowbit(int x) {
        return x & -x;
    }

    // 计算前缀和
    private static int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tr[i];
        }
        return res;
    }

    // 更新树状数组
    private static void add(int x, int v) {
        for (int i = x; i < M; i += lowbit(i)) {
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