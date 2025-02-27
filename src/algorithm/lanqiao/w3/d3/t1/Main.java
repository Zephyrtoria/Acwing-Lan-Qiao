/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-27
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w3.d3.t1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("0/1");
        sternBrocot(n, 1, 0, 1, 1);
        System.out.println("1/1");
    }

    // b/a d/c
    private static void sternBrocot(int n, int a, int b, int c, int d) {
        if (a + c > n) {
            return;
        }

        // (b + d) / (a + c)
        // 中序遍历
        // left, mid
        sternBrocot(n, a, b, a + c, b + d);
        // mid
        System.out.printf("%d/%d\n", b + d, a + c);
        // mid, right
        sternBrocot(n, a + c, b + d, c, d);
    }
}