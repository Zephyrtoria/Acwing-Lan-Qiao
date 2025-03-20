package algorithm.lanqiao.w6.d2.t2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            System.out.println(qmi(a, b, p));
        }
    }

    private static int qmi(int a, int b, int p) {
        int res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = (int) ((long) res * a % p);
            }
            a = (int) ((long) a * a % p);
            b >>= 1;
        }
        return res;
    }
}