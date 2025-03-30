package algorithm.lanqiao.w6.d4.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a;
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            System.out.println(count(a));
        }
    }

    private static int count(int x) {
        int res = 0;
        // 因数两两成对
        for (int i = 1; i <= x / i; i++) {
            if (x % i == 0) {
                res++;
                if (x / i != i) {
                    res++;
                }
            }
        }
        return res;
    }
}
