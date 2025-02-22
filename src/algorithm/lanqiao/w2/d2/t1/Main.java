/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-20
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d2.t1;

import java.util.*;

public class Main {
    private static final int N = 100010;
    
    private static Integer[] c = new Integer[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            c[i] = sc.nextInt();
        }

        // 从大到小排序
        Arrays.sort(c, 1, n + 1, (a, b) -> {
            // 返回值大于0则交换
            return b - a;
        });

        // 双指针
        int res = 0;
        // notes: j是随着i的增大而减小的，和之前同增的情况不一样，j要从n开始
        for (int i = 1, j = n; i <= n; i++) {
            while (j > 0 && c[j] < i) {
                j--;
            }
            if (c[i] >= i - 1 && i - j <= L) {
                res = i;
            }
        }

        System.out.println(res);
    }
}