package algorithm.lanqiao.w6.d4.t2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a;
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            divide(a);
            System.out.println();
        }
    }

    private static void divide(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    n /= i;
                    s++;
                }
                System.out.printf("%d %d\n", i, s);
            }
        }
        if (n > 1) {
            System.out.printf("%d %d\n", n, 1);
        }
    }
}
