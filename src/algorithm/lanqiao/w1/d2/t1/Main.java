/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-17
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w1.d2.t1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int T = Integer.parseInt(input);

        for (int t = 1; t <= T; t++) {
            input = br.readLine();
            int n = Integer.parseInt(input);
            input = br.readLine();
            int[] arr = new int[n + 1];
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = input.charAt(i - 1) - '0';
                preSum[i] = preSum[i - 1] + arr[i];
            }

            int range = (n + 1) / 2;
            int maxValue = 0;
            for (int i = 1; i <= n - range + 1; i++) {
                maxValue = Math.max(maxValue, preSum[i + range - 1] - preSum[i - 1]);
            }
            System.out.printf("Case #%d: %d\n", t, maxValue);
        }
    }
}