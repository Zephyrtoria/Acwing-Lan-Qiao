package algorithm.lanqiao.w5.d2.t2;

import java.util.*;

public class Main {
    static final int N = 12, M = 1 << N;
    static long[][] f;
    static boolean[] st = new boolean[M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while (n != 0 && m != 0) {
            // 预处理st，即通过查阅st[k]可以快速知道f[i][k]能否满足连续的空位置长度均为偶数
            for (int i = 0; i < 1 << n; i++) {
                // i表示所有可能的方案
                // cnt表示连续空格子数
                int cnt = 0;
                st[i] = true;
                for (int j = 0; j < n; j++) {
                    // j用来计算i的第j位是0还是1
                    if ((i >> j & 1) != 0) {
                        // 为1，非空位置
                        if ((cnt & 1) == 1) {
                            // cnt为奇数
                            st[i] = false;
                        }
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                }
                if ((cnt & 1) == 1) {
                    st[i] = false;
                }
            }

            f = new long[N][M];
            f[0][0] = 1L;
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < 1 << n; j++) {
                    // f[i]的状态j
                    for (int k = 0; k < 1 << n; k++) {
                        // f[i-1]的状态k
                        if ((j & k) == 0 && st[j | k]) {
                            // 两个状态不能在第i-1列重叠
                            // j | k = 两个状态合并后，在第i-1列的状态，判断是否合法
                            f[i][j] += f[i - 1][k];
                        }
                    }
                }
            }

            System.out.println(f[m][0]);
            n = sc.nextInt();
            m = sc.nextInt();
        }
    }
}