package algorithm.lanqiao.w1.d1.t4;

import java.util.*;

public class Main {
    static final int N = 100010;
    static int[] a = new int[N], b = new int[N];
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        // x有可能取0，最大值为1000000
        int l = 0, r = 1000000;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // 现在的l(或r)是这样的一个数：所有大于等于l的数的个数大于等于m
        // 且大于等于l+1的数的个数一定小于m
        // 现在只需要统计l之前所有数的总和即可
        long res = 0;
        // 取数的总个数，用来判断是否取了超出m个的数
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            // 运用等差数列的求和公式
            if (a[i] >= l) {
                // 项数
                int c = (a[i] - l) / b[i] + 1;
                cnt += c;
                // 尾项（注意b读入的时候是正数，但实际上是减去这个数，所以要负号）
                int end = a[i] - (c - 1) * b[i];
                // 求和公式
                res += ((long) (a[i] + end)) * c / 2;
            }
        }

        // 因为l取的是最大的一个能使所有大于等于l的数的个数大于等于m的数
        // 可能出现cnt > m的情况，所以还要减去这一部分
        res -= (cnt - m) * l;
        System.out.println(res);
    }

    // 计算大于等于x的所有数的个数是否大于等于m
    private static boolean check(int x) {
        long res = 0;
        // 通过等差数列性质求，a-nb >= x -> n = [(a-x)/b]+1
        for (int i = 0; i < n; i++) {
            // 首项必须大于等于x才行
            if (a[i] >= x) {
                res += (a[i] - x) / b[i] + 1;
            }
        }
        return res >= m;
    }
}
