package algorithm.lanqiao.w3.d1.t5;

import java.util.Scanner;

public class Main {
    static final int[] MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int d = sc.nextInt();

        int m = 1;
        int res = 0;
        while (d-- > 0) {
            res++;
            if (res > getDays(y, m)) {
                m++;
                res = 1;
            }
        }
        System.out.printf("%d\n%d\n", m, res);
    }

    private static int leap(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return 1;
        }
        return 0;
    }

    private static int getDays(int year, int month) {
        if (month == 2) {
            return MONTH[2] + leap(year);
        }
        return MONTH[month];
    }
}
