package algorithm.lanqiao.w5.d4.t1;

import java.util.*;

public class Main {
    static final int N = 10010;
    static long[] f = new long[N];
    static int[] v = new int[30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
        }

        // dp
        // 初始化
        f[0] = 1;
        for (int i = 1; i <= n ; i++) {
            for (int j = v[i]; j <= V; j++) {
                f[j] += f[j - v[i]];
            }
        }
        System.out.println(f[V]);
    }
}