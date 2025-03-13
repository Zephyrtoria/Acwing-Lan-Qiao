package algorithm.lanqiao.w4.d3.t4;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 100010;
    static int[] q = new int[N];
    static int[] res = new int[N];
    // 并查集
    static int[] prt;
    // 指向最后一位的下一个
    static int end;

    public static int find(int x) {
        if (prt[x] != x) {
            // 不修改父节点
            return find(prt[x]);
        }
        return x;
    }

    public static void unite(int a, int b) {
        // 将两个父节点连接到一个新的节点上
        int fa = find(a);
        int fb = find(b);
        if (fa == fb) {
            return;
        }
        prt[fa] = prt[fb] = end;
        end++;
    }

    public static void main(String[] args) throws Exception {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        prt = new int[N];
        for (int i = 1; i < N; i++) {
            prt[i] = i;
        }
        end = n + 1;

        for (int i = 0; i < m; i++) {
            int choice = Reader.nextInt();
            if (choice == 1) {
                int a = Reader.nextInt();
                int b = Reader.nextInt();
                unite(a, b);
            } else {
                int p = Reader.nextInt();
                int t = Reader.nextInt();
                // 树状差分数组
                q[find(p)] += t;
            }
        }

        for (int i = 1; i <= n; i++) {
            int c = i;
            while (c != prt[c]) {
                res[i] += q[c];
                c = prt[c];
            }
            // 本身就是根节点
            res[i] += q[c];
            System.out.printf("%d ", res[i]);
        }
    }
}

class Reader {
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