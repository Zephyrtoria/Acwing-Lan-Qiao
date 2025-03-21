package algorithm.lanqiao.w5.d5.t1;

import java.util.*;

public class Main {
    static final int N = 110;
    static int[] w = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            sum += w[i];
        }

        // 先枚举长度
        for (int len = 1; len <= n; len++) {
            // 再枚举起点
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (j == i) {
                    f[i][j] = w[i] - f[i + 1][j];
                } else {
                    f[i][j] = Math.max(w[i] - f[i + 1][j], w[j] - f[i][j - 1]);
                }
            }
        }

        // A + B = sum; A - B = d
        int d = f[0][n - 1];
        System.out.printf("%d %d\n", (sum + d) / 2, (sum - d) / 2);
    }
}
