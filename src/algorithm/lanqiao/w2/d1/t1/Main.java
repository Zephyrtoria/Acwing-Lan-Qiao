/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-18
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d1.t1;

import java.io.*;

public class Main {
    private static int N = 100010;
    private static int[] p = new int[N];
    private static int[] t = new int[N];
    private static int[] d = new int[N];
    private static int[] b = new int[N];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(input[i - 1]);
        }
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            t[i] = Integer.parseInt(input[i - 1]);
        }
        // D数组和差分数组B，算到第n+1位可以满足所有和为0
        for (int i = 1; i <= n + 1; i++) {
            d[i] = p[i] - t[i];
            b[i] = d[i] - d[i - 1];
        }
        // 计算S
        int s = 0;
        for (int i = 1; i <= n + 1; i++) {
            if (b[i] > 0) {
                s += b[i];
            }
        }
        System.out.println(s);
    }
}