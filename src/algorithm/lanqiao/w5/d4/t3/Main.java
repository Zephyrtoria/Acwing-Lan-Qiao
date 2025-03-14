package algorithm.lanqiao.w5.d4.t3;

import java.util.*;

public class Main {
    static final int N = 1010;
    static int[] f = new int[N];
    static int[] v = new int[N];
    static int[] w = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        // 一维数组dp
        for (int i = 1; i <= n; i++) {
            // 每一次f[j]取用的要么是上一层的当前位，要么是本层的f[j-v[i]]
            // 要和普通01背包区分，看清是取的哪一层的数据，来决定j的遍历方向
            // 遍历本层的数据，则应该从小到大遍历
            // 又由于j < v[i]时数据不会更新，所以可以直接从v[i]开始遍历
            for (int j = v[i]; j <= V; j++) {
                // f[i][j] = max(f[i - 1][j], f[i][j - v[i]] + w[i])
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[V]);
    }
}