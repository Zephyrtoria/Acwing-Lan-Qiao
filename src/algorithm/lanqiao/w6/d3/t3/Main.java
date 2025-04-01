package algorithm.lanqiao.w6.d3.t3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 100010;
    static int[] a = new int[N], d = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 所有差的最大公因数
        Arrays.sort(a, 0, n);
        for (int i = 0; i < n - 1; i++) {
            d[i] = a[i + 1] - a[i];
        }

        int g = gcd(d[0], d[1]);
        if (g == 0) {
            System.out.println(n);
            return;
        }
        for (int i = 2; i < n - 1; i++) {
            g = gcd(g, d[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += d[i] / g - 1;
        }
        res += n;
        System.out.println(res);
    }

    private static int gcd(int x, int b) {
        return b == 0 ? x : gcd(b, x % b);
    }
}
