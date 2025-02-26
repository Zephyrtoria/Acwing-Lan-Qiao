/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-26
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w3.d1.t2;

import java.util.*;

public class Main {
    static final int[] MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    // YY/MM/DD MM/DD/YY DD/MM/YY
    static final int[][] RANGE = {{0, 1, 2}, {2, 1, 0}, {2, 0, 1}};

    static class Date implements Comparable<Date> {
        int y, m, d;
        public Date(int y, int m, int d) {
            if (y < 60) {
                y = 2000 + y;
            } else {
                y = 1900 + y;
            }
            this.y = y;
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Date o) {
            if (this.y == o.y) {
                if (this.m == o.m) {
                    return this.d - o.d;
                }
                return this.m - o.m;
            }
            return this.y - o.y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.next().split("/");
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Set<Date> result = new TreeSet<>();
        for (int i = 0; i < 3; i++) {
            Date date = new Date(nums[RANGE[i][0]], nums[RANGE[i][1]], nums[RANGE[i][2]]);
            if (checkValid(date)) {
                result.add(date);
            }
        }

        for (Date each : result) {
            System.out.println(dateToString(each));
        }
    }

    private static boolean checkValid(Date date) {
        int y = date.y, m = date.m, d = date.d;
        // 月份
        if (m == 0 || m > 12) {
            return false;
        }
        // 日期
        if (d == 0 || d > getDays(y, m)) {
            return false;
        }
        return true;
    }

    private static String dateToString(Date date) {
        int y = date.y, m = date.m, d = date.d;

        return String.format("%d-%02d-%02d", y, m, d);
    }

    private static int isLeapYear(int y) {
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
            return 1;
        }
        return 0;
    }

    private static int getDays(int y, int m) {
        if (m == 2) {
            return 28 + isLeapYear(y);
        }
        return MONTHS[m];
    }
}