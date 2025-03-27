package algorithm.lanqiao.w3.d1.t3;

import java.util.Scanner;

public class Main {
    static final int[] MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String d1 = sc.next();
        String d2 = sc.next();

        int y1 = Integer.parseInt(d1.substring(0, 4));
        int y2 = Integer.parseInt(d2.substring(0, 4));
        int res = 0;
        char[] ch;
        for (int y = y1; y <= y2; y++) {
            ch = new char[8];
            int re = 0, temp = y;
            for (int i = 3; i >= 0; i--) {
                ch[i] = (char) (temp % 10 + '0');
                temp /= 10;
            }
            temp = y;
            for (int i = 4; i < 8; i++) {
                ch[i] = (char) (temp % 10 + '0');
                temp /= 10;
            }
            String s = String.valueOf(ch);
            if (!dateValid(s)) {
                continue;
            }
            if (s.compareTo(d1) >= 0 && s.compareTo(d2) <= 0) {
                System.out.println(s);
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean isLeapYear(int y) {
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
    }

    private static int getDays(int y, int m) {
        if (m == 2) {
            return isLeapYear(y) ? MONTH[m] + 1 : MONTH[m];
        }
        return MONTH[m];
    }

    private static boolean dateValid(String s) {
        int y = Integer.parseInt(s.substring(0, 4));
        int m = Integer.parseInt(s.substring(4, 6));
        int d = Integer.parseInt(s.substring(6));
        if (m == 0 || m > 12) {
            return false;
        }
        return d != 0 && d <= getDays(y, m);
    }
}
