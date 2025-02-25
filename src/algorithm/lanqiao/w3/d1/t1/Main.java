package algorithm.lanqiao.w3.d1.t1; /**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-25
 * @Description:
 * @Version: 1.0
 */

import java.util.*;

public class Main {
    static final int[] MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            int ra = calculate(a);
            int rb = calculate(b);
            System.out.println(Math.abs(ra - rb) + 1);
        }
    }

    private static int calculate(String date) {
        int y = Integer.parseInt(date.substring(0, 4));
        int m = Integer.parseInt(date.substring(4, 6));
        int d = Integer.parseInt(date.substring(6, 8));
        int res = 0;
        // 前y - 1年
        for (int i = 1; i < y; i ++) {
            res += 365 + isLeapYear(i);
        }
        // 第y年的月份
        for (int i = 1; i < m; i++) {
            res += getDays(y, i);
        }
        // 第y年的m月的天数
        res += d;
        return res;
    }

    private static int getDays(int y, int m) {
        if (m == 2) {
            return 28 + isLeapYear(y);
        }
        return MONTHS[m];
    }

    private static int isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return 1;
        }
        return 0;
    }
}