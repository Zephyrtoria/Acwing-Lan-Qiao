package algorithm.lanqiao.w7.d3.t4;

import java.util.Scanner;

public class Main {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long b = sc.nextLong();

        // 对1特判
        if (a == 1) {
            System.out.println(0);
            return;
        }

        // 分解质因数，求欧拉函数
        int euler = euler(a);
        long res = euler * qmi(a, b - 1, MOD) % MOD;
        System.out.println(res);
    }

    private static int euler(int a) {
        int res = a;
        for (int i = 2; i <= a / i; i++) {
            if (a % i == 0) {
                while (a % i == 0) {
                    a /= i;
                }
                res = res / i * (i - 1);
            }
        }
        if (a > 1) {
            res = res / a * (a - 1);
        }
        return res;
    }

    private static long qmi(long a, long k, long m) {
        long res = 1;
        while (k > 0) {
            if (k % 2 == 1) {
                res = res * a % m;
            }
            k >>= 1;
            a = a * a % m;
        }
        return res;
    }
}
