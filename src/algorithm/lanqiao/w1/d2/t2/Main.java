/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-22
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w1.d2.t2;

import java.io.*;
public class Main {
    private static final int N = 100010;
    private static final int[] arr = new int[N];
    private static final int[] preSum = new int[N];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            System.out.println(preSum[Integer.parseInt(input[1])] - preSum[Integer.parseInt(input[0]) - 1]);
        }
    }
}