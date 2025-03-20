package algorithm.lanqiao.w5.d5.t2;

import java.util.*;

public class Main {
    static final int N = 310;
    static int[][] f = new int[N][N];
    static int[] a = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i - 1] + a[i];
        }

        // dp
        // 先枚举区间长度
        for (int len = 2; len <= n; len++) {
            // 再枚举区间起点
            for (int i = 1; i + len - 1 <= n; i++) {
                // 直接获取终点
                int j = i + len - 1;
                f[i][j] = 0x3f3f3f3f;
                // 枚举分界点
                // [i, k] and [k + 1, j]
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + s[j] - s[i - 1]);
                }
            }
        }

        System.out.println(f[1][n]);
    }
}