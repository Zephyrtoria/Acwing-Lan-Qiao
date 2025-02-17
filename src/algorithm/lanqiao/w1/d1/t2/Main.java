/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-17
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w1.d1.t2;

import java.io.*;

public class Main {
    private static int N = 100010;
    private static int[] h = new int[N];
    private static int[] w = new int[N];
    private static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            h[i] = Integer.parseInt(input[0]);
            w[i] = Integer.parseInt(input[1]);
        }

        int left = 1, right = N;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(mid)) {
                // 数额大于等于k，找右半部分
                left = mid;
            } else {
                // 数额小于k，找左半部分
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    // 切边长为x能切出多少块
    private static boolean check(int x) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            // 可能会超出数据范围 10^5 * 10^5
            sum += (long)(h[i] / x) * (w[i] / x);
            if (sum >= k) {
                return true;
            }
        }
        return false;
    }
}