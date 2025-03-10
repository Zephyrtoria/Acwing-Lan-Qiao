package algorithm.lanqiao.w4.d5.t3;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 1000010;
    static int[] arr = new int[N];
    static int[] q = new int[N];
    static int hh = 0, tt = 0;

    public static void main(String[] args) throws Exception {
        int n = Reader.nextInt();
        int k = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = Reader.nextInt();
        }

        for (int i = 0; i < n; i++) {
            // 判断队列左端是否出窗口
            if (i - k + 1 > q[hh]) {
                hh++;
            }
            // 从队尾添加元素，保证实现编号递增，且编号对应数组中的值递增
            while (hh != tt && arr[q[tt - 1]] >= arr[i]) {
                tt--;
            }
            q[tt++] = i;

            // 当形成窗口时进行输出
            if (i >= k - 1) {
                System.out.printf("%d ", arr[q[hh]]);
            }
        }
        System.out.println();

        hh = tt = 0;
        q = new int[N];
        for (int i = 0; i < n; i++) {
            // 判断队列左端是否出窗口
            if (i - k + 1 > q[hh]) {
                hh++;
            }
            // 从队尾添加元素，保证实现编号递增，且编号对应数组中的值递减
            while (hh != tt && arr[q[tt - 1]] <= arr[i]) {
                tt--;
            }
            q[tt++] = i;

            // 当形成窗口时进行输出
            if (i >= k - 1) {
                System.out.printf("%d ", arr[q[hh]]);
            }
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
}
