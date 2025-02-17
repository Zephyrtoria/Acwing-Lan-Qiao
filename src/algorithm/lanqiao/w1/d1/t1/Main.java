/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-16
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w1.d1.t1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int N = 1000010;
    private static final int[] s = new int[N];
    private static final int[] t = new int[N];
    private static final int[] d = new int[N];
    private static final long[] r = new long[N];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n, m;
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            r[i] = Long.parseLong(input[i - 1]);
        }
        for (int i = 1; i <= m; i++) {
            input = br.readLine().split(" ");
            d[i] = Integer.parseInt(input[0]);
            s[i] = Integer.parseInt(input[1]);
            t[i] = Integer.parseInt(input[2]);
        }

        int result = binarySearch(n, m);
        if (result == m) {
            System.out.println(0);
        } else {
            System.out.println(-1);
            System.out.println(result + 1);
        }
    }

    private static int binarySearch(int n, int m) {
        // left从0开始，因为可能所有订单都不满足
        int left = 0, right = m;
        // 要找能够满足条件的最大的k
        while (left < right) {
            // left == mid就要上一位；right == mid就不用
            int mid = (left + right + 1) >> 1;
            if (isValid(n, mid)) {
                // 满足条件，找右区间
                // 又因为要找最大的k，所以不能写left = mid + 1，要保留
                left = mid;
            } else {
                // 不满足条件，找左区间
                right = mid - 1;
            }
        }
        return left;
    }

    private static boolean isValid(int n, int k) {
        long[] de = new long[N];
        for (int i = 1; i <= k; i++) {
            de[s[i]] += d[i];
            de[t[i] + 1] -= d[i];
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += de[i];
            if (sum > r[i]) {
                return false;
            }
        }
        return true;
    }
}