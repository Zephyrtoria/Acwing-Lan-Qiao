/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-22
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d1.t2;

import java.util.*;

public class Main {
    private static final int N = 100010;
    private static int[] arr = new int[N];
    private static int[] df = new int[N];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            df[i] = arr[i] - arr[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();

            df[l] += c;
            df[r + 1] -= c;
        }
        for (int i = 1; i <= n; i++) {
            df[i] += df[i - 1];
            System.out.printf("%d ", df[i]);
        }
    }
}