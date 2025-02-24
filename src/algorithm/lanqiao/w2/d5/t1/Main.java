/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-24
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d5.t1;

import java.util.*;

public class Main {
    static int N = 500010;
    static String cows;
    static int[] l = new int[N];
    static int[] r = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cows = sc.next();

        // 初始化连续的H和G的长度数组
        // l[i]表示在i左侧有多少连续个与i不同的牛；r[i]表示在i右侧有多少连续个与i不同的牛
        int sh = 0, sg = 0;
        for (int i = 0; i < n; i++) {
            if (cows.charAt(i) == 'H') {
                l[i] = sg;
                sg = 0;
                sh++;
            } else {
                l[i] = sh;
                sh = 0;
                sg++;
            }
        }

        sg = sh = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cows.charAt(i) == 'H') {
                r[i] = sg;
                sg = 0;
                sh++;
            } else {
                r[i] = sh;
                sh = 0;
                sg++;
            }
        }

        // 判断每头牛是否为孤独牛
        // 将判断区间的操作转换为判断牛的操作
        long res = 0;
        for (int i = 0; i < n; i++) {
            // 三种情况实际上同时只会出现一种，所以可以直接写在一起
            // 同时max()保证不会出现负数
            res += (long)l[i] * r[i] + Math.max(r[i] - 1, 0) + Math.max(l[i] - 1, 0);
        }
        System.out.println(res);
    }

}