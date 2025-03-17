package algorithm.lanqiao.w5.d3.t1;

import java.util.*;

public class Main {
    static final int N = 360;
    static final int M = 41;
    static int[] w = new int[N];
    static int[] s = new int[N];
    static int[][][][] f = new int[M][M][M][M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            s[x]++;
        }

        // 起点
        f[0][0][0][0] = w[1];
        for (int A = 0; A <= s[1]; A++) {
            for (int B = 0; B <= s[2]; B++) {
                for (int C = 0; C <= s[3]; C++) {
                    for (int D = 0; D <= s[4]; D++) {
                        int score = w[1 + A + 2 * B + 3 * C + 4 * D];
                        int temp = f[A][B][C][D];
                        if (A > 0) temp = Math.max(f[A - 1][B][C][D] + score, temp);
                        if (B > 0) temp = Math.max(f[A][B - 1][C][D] + score, temp);
                        if (C > 0) temp = Math.max(f[A][B][C - 1][D] + score, temp);
                        if (D > 0) temp = Math.max(f[A][B][C][D - 1] + score, temp);
                        f[A][B][C][D] = temp;
                    }
                }
            }
        }

        System.out.println(f[s[1]][s[2]][s[3]][s[4]]);
    }
}