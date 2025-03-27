package algorithm.lanqiao.w6.d2.t1;

import java.util.*;

public class Main {
    static final int N = 1000010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        // 每n轮回到原点，将10^k模n
        int t = qmi(10, k, n);
        for (int i = 0; i < t; i++) {
            x = (x + m) % n;
        }
        System.out.println(x);
    }

    private static int qmi(int a, int k, int mod) {
        int res = 1;
        while (k > 0) {
            if (k % 2 == 1) {
                res = (int) ((long) res * a % mod);
            }
            a = (int)((long) a * a % mod);
            k >>= 1;
        }
        return res;
    }
}