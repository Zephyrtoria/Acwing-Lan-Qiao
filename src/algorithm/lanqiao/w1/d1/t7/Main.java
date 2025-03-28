package algorithm.lanqiao.w1.d1.t7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 100010;
    static final double eps = 1e-6, INF = 1e9;
    static int[] a = new int[N];
    static double[] sum = new double[N];
    static int n, f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        double l = 0, r = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            // 平均值必然小于等于最大的数
            r = Math.max(r, a[i]);
        }

        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println((int) (r * 1000));
    }

    private static boolean check(double x) {
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + a[i] - x;
        }

        double minv = INF;
        for (int i = 0, j = f; j <= n; i++, j++) {
            // 寻找最优极小值
            minv = Math.min(minv, sum[i]);
            if (sum[j] - minv >= 0) {
                return true;
            }
        }
        return false;
    }
}
