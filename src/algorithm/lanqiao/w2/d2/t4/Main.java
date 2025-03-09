/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-09
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d2.t4;

import java.util.*;

public class Main {
    static final int N = 100010;
    static int[] p = new int[N];
    static int[] q = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            q[i] = sc.nextInt();
        }

        for (int slow = 0, fast = 0; slow < n; slow++) {
            while (fast < m && p[slow] != q[fast]) {
                fast++;
            }
            if (fast >= m) {
                System.out.println("No");
                return;
            }
            fast++;
        }
        System.out.println("Yes");
    }
}