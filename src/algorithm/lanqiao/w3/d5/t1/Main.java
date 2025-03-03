/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-03
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w3.d5.t1;

import java.util.*;

public class Main {
    static int n;
    static int sum;
    static int len;
    static boolean[] visited;
    static Integer[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while ((n = sc.nextInt()) != 0) {
            sum = len = 0;
            arr = new Integer[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                // 每次枚举的长度，最小也要从 max(arr) + 1 开始
                sum += arr[i];
                len = Math.max(len, arr[i]);
            }
            Arrays.sort(arr, (a, b) -> {
                return b - a;
            });

            // 必定有解（拼成一根长木棍）
            while (true) {
                // 要拆成整数
                if (sum % len == 0 && backtracking(0, 0, 0)) {
                    System.out.println(len);
                    break;
                }
                len++;
            }
        }
    }

    /**
     * @param u          当前是第几根长木棍
     * @param cur        当前这根长木棍已经拼出来的长度
     * @param startIndex 起始下标
     * @return 是否有解
     */
    private static boolean backtracking(int u, int cur, int startIndex) {
        // u 根长度为 len 的木棍
        if (u * len == sum) {
            return true;
        }
        // 当前长木棍已经拼好，要重新从第0根木棍进行遍历
        if (cur == len) {
            return backtracking(u + 1, 0, 0);
        }
        // 回溯
        for (int i = startIndex; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            // 还能加入新的小木棍
            if (cur + arr[i] <= len) {
                visited[i] = true;
                if (backtracking(u, cur + arr[i], i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
            // 剪枝（只要执行到这里，就说明当前小木棍放入失败）
            // 1. cur == 0 第一个未被用过的小木棍，作为新长木棍的第一根无解
            // 2. 当前小木棍加入长木棍后，当前长木棍已满足要求，但后续无法凑成长木棒，无解
            if (cur == 0 || cur + arr[i] == len) {
                return false;
            }
            // 3. 当前小木棍放入失败，则跳过所有长度相同的小木棍
            int j = i + 1;
            while (j < n && arr[i].equals(arr[j])) {
                j++;
            }
            i = j - 1;
        }
        return false;
    }
}