package algorithm.lanqiao.w6.d3.t1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 1500;
    static int[] q = new int[N];
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int query = sc.nextInt();

        // 预处理约数
        initDivisors(a, b);
        for (int i = 0; i < cnt; i++) {
            System.out.printf("%d ", q[i]);
        }
        System.out.println();

        int L, R, l, r;
        while (query-- > 0) {
            L = sc.nextInt();
            R = sc.nextInt();

            l = 0;
            r = cnt - 1;
            while (l < r) {
                int mid = l + r  + 1>> 1;
                if (q[mid] <= R) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (L <= q[l]) {
                System.out.println(q[l]);
            } else {
                System.out.println(-1);
            }
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static void initDivisors(int a, int b) {
        int d = gcd(a, b);
        for (int i = 1; i <= d / i; i++) {
            if (d % i == 0) {
                q[cnt++] = i;
                if (i != d / i) {
                    q[cnt++] = d / i;
                }
            }
        }
        // 为了方便二分，可以进行排序，或者直接暴力搜索也可以
        Arrays.sort(q, 0, cnt);
    }
}
