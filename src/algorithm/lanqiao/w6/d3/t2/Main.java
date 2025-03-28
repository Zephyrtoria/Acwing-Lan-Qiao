package algorithm.lanqiao.w6.d3.t2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a, b;
        while (n-- > 0) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(gcd(a, b));
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
