package algorithm.lanqiao.w5.d3.t3;

import java.util.*;

public class Main {
    static final int N = 1010;
    static int[][] f = new int[N][N];
    static char[] a = new char[N];
    static char[] b = new char[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String input = sc.next();
        for (int i = 1; i <= n; i++) {
            a[i] = input.charAt(i - 1);
        }
        input = sc.next();
        for (int i = 1; i <= m; i++) {
            b[i] = input.charAt(i - 1);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a[i] == b[j]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }

        System.out.println(f[n][m]);
    }
}