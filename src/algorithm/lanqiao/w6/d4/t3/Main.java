package algorithm.lanqiao.w6.d4.t3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(divide(n));
    }

    private static int divide(long n) {
        if (n == 1) {
            return 0;
        }
        int res = 0;
        // 枚举因数
        for (int i = 2; i <= n / i; i++) {
            // 分解质因数
            if (n % i == 0) {
                res++;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        // 本身是因数
        if (n > 1) {
            res++;
        }
        return res;
    }
}
