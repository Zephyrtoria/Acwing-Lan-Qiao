package algorithm.lanqiao.w5.d4.t4;

import java.util.*;

public class Main {
    static final int N = 10010;
    static int[] a = new int[N];
    static boolean[] dp = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = 0, amax = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            amax = Math.max(amax, a[i]);
            if (i == 0) {
                d = a[i];
            } else {
                d = gcd(d, a[i]);
            }
        }
        // 最大公约数不为1
        if (d != 1) {
            System.out.println("INF");
            return;
        }

        // dp
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            // 需要用到本层数据，从小到大
            for (int j = a[i]; j < N; j++) {
                dp[j] = dp[j] || dp[j - a[i]];
            }
        }

        // 记录凑不出的数目
        int res = 0;
        // 记录能连续凑出的数目
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!dp[i]) {
                res++;
                count = 0;
            } else {
                count++;
            }
            if (count == amax) {
                break;
            }
        }
        System.out.println(res);
    }

    private static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}