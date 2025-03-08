/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-08
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d2.t3;

import java.util.*;

public class Main {
    static final int N = 100010;
    static int[] arr = new int[N];
    static int[] brr = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int j = 0; j < m; j++) {
            brr[j] = sc.nextInt();
        }

        for (int i = 0, j = m - 1; i < n; i++) {
            while (j >= 0 && arr[i] + brr[j] > x) {
                j--;
            }
            if (j >= 0 && arr[i] + brr[j] == x) {
                System.out.printf("%d %d\n", i, j);
            }
        }
    }
}