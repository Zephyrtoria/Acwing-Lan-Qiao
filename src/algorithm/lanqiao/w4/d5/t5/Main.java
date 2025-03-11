package algorithm.lanqiao.w4.d5.t5;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 100010;
    static long[] arr = new long[N];
    static int[] lmax = new int[N];
    static int[] rmax = new int[N];
    static int n;
    static int[] q = new int[N];
    static int top;

    public static void main(String[] args) throws Exception {
        while ((n = Reader.nextInt()) != 0) {
            for (int i = 0; i < n; i++) {
                arr[i] = Reader.nextLong();
            }

            // 向左能够延伸的长度，不包含本身
            // 使用单调栈，存放索引，每次寻找第一个高度比自己小的位置
            top = -1;
            for (int i = 0; i < n; i++) {
                while (top >= 0 && arr[q[top]] >= arr[i]) {
                    top--;
                }
                lmax[i] = top == -1 ? i : i - q[top] - 1;
                q[++top] = i;
            }

            // 向右能够延伸的长度，不包含本身
            top = -1;
            for (int i = n - 1; i >= 0; i--) {
                while (top >= 0 && arr[q[top]] >= arr[i]) {
                    top--;
                }
                rmax[i] = top == -1 ? n - 1 - i : q[top] - i - 1;
                q[++top] = i;
            }

            long res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, arr[i] * (lmax[i] + rmax[i] + 1));
            }
            System.out.println(res);
        }
    }
}

class Reader {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token = new StringTokenizer("");

    public static String nextLine() throws Exception {
        return br.readLine();
    }

    public static String next() throws Exception {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(nextLine());
        }
        return token.nextToken();
    }

    public static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws Exception {
        return Long.parseLong(next());
    }
}