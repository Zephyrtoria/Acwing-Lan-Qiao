package algorithm.lanqiao.w2.d1.t5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 100010;
    static int[] a = new int[N], d = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int l, r;
        while (m-- > 0) {
            l = sc.nextInt();
            r = sc.nextInt();
            d[l] += 1;
            d[r + 1] -= 1;
        }

        for (int i = 1; i <= n; i++) {
            d[i] += d[i - 1];
        }

        long priAns = 0, aftAns = 0;
        // 原答案
        for (int i = 1; i <= n; i++) {
            priAns += (long) a[i] * d[i];
        }
        // 排序后答案
        Arrays.sort(a, 1, n + 1);
        Arrays.sort(d, 1, n + 1);
        for (int i = 1; i <= n; i++) {
            aftAns += (long) a[i] * d[i];
        }
        System.out.println(aftAns - priAns);
    }
}
