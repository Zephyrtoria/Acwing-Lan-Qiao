package algorithm.lanqiao.w7.d3.t2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a;
        while (n-- > 0) {
            a = sc.nextInt();
            System.out.println(euler(a));
        }
    }

    private static int euler(int a) {
        int res = a;
        int s;
        for (int i = 2; i <= a / i; i++) {
            s = 0;
            if (a % i == 0) {
                while (a % i == 0) {
                    s++;
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
}
