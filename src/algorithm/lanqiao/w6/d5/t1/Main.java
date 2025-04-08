package algorithm.lanqiao.w6.d5.t1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MOD = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while ((n = sc.nextInt()) != -1) {
            System.out.println(fbi(n));
        }
    }

    private static void mul(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            a[i] = Arrays.copyOf(c[i], 2);
        }
    }

    private static int fbi(int n) {
        int[][] a = {{0, 1}, {0, 0}};
        int[][] f = {{0, 1}, {1, 1}};
        while (n > 0) {
            if (n % 2 == 1) {
                mul(a, f);
            }
            mul(f, f);
            n >>= 1;
        }
        return a[0][0];
    }
}
