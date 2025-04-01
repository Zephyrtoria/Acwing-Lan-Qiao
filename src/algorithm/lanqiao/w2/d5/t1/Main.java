package algorithm.lanqiao.w2.d5.t1;

import java.util.Scanner;

public class Main {
    static final int N = 500010;
    static char[] cow;
    static int[] ls = new int[N], rs = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cow = sc.next().toCharArray();

        // 初始化连续的H和G的长度数组
        // ls[i]表示在i左侧有多少连续个与i不同的牛；rs[i]表示在i右侧有多少连续个与i不同的牛
        char preCow = cow[0];
        ls[0] = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (cow[i] == preCow) {
                ls[i] = 0;
                count++;
            } else {
                ls[i] = count;
                count = 1;
                preCow = cow[i];
            }
        }

        preCow = cow[n - 1];
        rs[n - 1] = 0;
        count = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (cow[i] == preCow) {
                rs[i] = 0;
                count++;
            } else {
                rs[i] = count;
                count = 1;
                preCow = cow[i];
            }
        }

        // 判断每头牛是否为孤独牛
        // 将判断区间的操作转换为判断牛的操作
        long res = 0;
        for (int i = 0; i < n; i++) {
            // 全取左，全取右，左右都有取
            if (ls[i] >= 2) {
                res += ls[i] - 1;
            }
            if (rs[i] >= 2) {
                res += rs[i] - 1;
            }
            if (ls[i] + rs[i] >= 2) {
                res += (long) ls[i] * rs[i];
            }
        }
        System.out.println(res);
    }
}