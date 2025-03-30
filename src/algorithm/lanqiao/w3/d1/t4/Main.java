package algorithm.lanqiao.w3.d1.t4;

import java.util.Scanner;

public class Main {
    static final int[] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String date;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        date = sc.next();

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6));
        StringBuilder sb;
        int y, temp;
        for (y = year; y < 10000; y++) {
            sb = new StringBuilder();
            sb.append(y);
            temp = y;
            for (int i = 0; i < 4; i++) {
                sb.append(temp % 10);
                temp /= 10;
            }
            if (check(sb)) {
                if (sb.toString().compareTo(date) <= 0) {
                    continue;
                }
                System.out.println(sb.toString());
                break;
            }
        }

        for (; y < 10000; y++) {
            sb = new StringBuilder();
            sb.append(y);
            temp = y;
            for (int i = 0; i < 4; i++) {
                sb.append(temp % 10);
                temp /= 10;
            }
            if (check(sb) && checkAB(sb)) {
                System.out.println(sb.toString());
                break;
            }
        }
    }

    private static boolean checkAB(StringBuilder sb) {
        String string = sb.toString();
        return string.charAt(0) != string.charAt(1) && string.substring(0, 2).equals(string.substring(2, 4));
    }

    private static boolean check(StringBuilder sb) {
        String string = sb.toString();
        int year = Integer.parseInt(string.substring(0, 4));
        int month = Integer.parseInt(string.substring(4, 6));
        int day = Integer.parseInt(string.substring(6));
        if (month == 0 || month > 12) {
            return false;
        } else if (day == 0 || day > getDays(year, month)) {
            return false;
        }
        return string.equals(sb.reverse().toString());
    }

    private static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static int getDays(int year, int month) {
        if (month == 2) {
            return isLeap(year) ? DAYS[month] + 1 : DAYS[month];
        }
        return DAYS[month];
    }
}
