/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-23
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w1.d2.t3;

import java.util.*;

public class Main {
    static final int N = 1010;
    static int[][] arr = new int[N][N];
    static int[][] preSum = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
                preSum[i][j] = arr[i][j] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            System.out.println(preSum[x2][y2] - preSum[x2][y1 - 1] - preSum[x1 - 1][y2] + preSum[x1 - 1][y1-  1]);
        }
    }
}