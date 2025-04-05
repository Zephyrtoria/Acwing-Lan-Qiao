package algorithm.lanqiao.w2.d4.t2;

import java.util.Scanner;

public class Main {
    static final int N = 100010;
    static long[] a = new long[N], b = new long[N];
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
        }

        // 寻找第m大的数x
        long l = 0, r = 2 * (long) 1e9;
        while (l < r) {
            long mid = (l + r + 1) / 2;
            if (check(mid)) {
                // 有多于m个数大于x，x可以取更大
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // 计算总和
        long res = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= l) {
                // 求和公式
                long t = (a[i] - l) / b[i] + 1;
                res += (a[i] + a[i] - (t - 1) * b[i]) * t / 2;
                // 统计个数
                count += t;
            }
        }
        // 超出的要减去
        res -= (count - m) * l;
        System.out.println(res);
    }

    private static boolean check(long x) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            // a - (t - 1)b >= x -> t = floor((a-x)/b) + 1
            if (a[i] >= x) {
                count += (a[i] - x) / b[i] + 1;
            }
        }
        return count >= m;
    }
}
