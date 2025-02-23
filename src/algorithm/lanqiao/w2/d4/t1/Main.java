/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-23
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d4.t1;

import java.util.*;

public class Main {
    static final int N = 110;
    static int[] fir = new int[N];
    static int[] dec = new int[N];
    static int[] dis = new int[N];
    static int[] spends;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            fir[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            dec[i] = sc.nextInt();
        }
        for (int i = 2; i <= n; i++) {
            dis[i] = sc.nextInt();
        }
        int T = sc.nextInt();

        // 前缀和来计算耗时之和
        for (int i = 2; i <= n; i++) {
            dis[i] = dis[i - 1] + dis[i];
        }

        // 遍历终点
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, work(i, T - dis[i]));
        }
        System.out.println(result);
    }

    private static int get(int k) {
        return Math.max(0, fir[k] - dec[k] * spends[k]);
    }

    private static int work(int n, int T) {
        int res = 0;
        spends = new int[n + 1];

        // 多路归并
        for (int i = 0; i < T; i++) {
            int t = 1;
            for (int j = 2; j <= n; j++) {
                if (get(t) < get(j)) {
                    t = j;
                }
            }
            res += get(t);
            spends[t]++;
        }
        return res;
    }
}