package algorithm.lanqiao.w5.d4.t5;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static final int N = 1010, INF = 0x3f3f3f3f;
    static LinkedList<Integer>[] a = new LinkedList[N];
    static int[][] f = new int[4][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            a[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            a[mod(x, m)].add(x);
        }

        for (int i = 0; i <= 3; i++) {
            Arrays.fill(f[i], -INF);
        }
        f[0][0] = 0;
        // 遍历所有的余数
        for (int i = 0; i < m; i++) {
            // 取出前3个最大的（不一定有3个）
            Collections.sort(a[i]);
            Collections.reverse(a[i]);
            for (int u = 0; u < Math.min(3, a[i].size()); u++) {
                int x = a[i].get(u);
                // 每次使用上一层，从大到小遍历
                for (int j = 3; j >= 1; j--) {
                    for (int k = 0; k < m; k++) {
                        f[j][k] = Math.max(f[j][k], f[j - 1][mod(k - x, m)] + x);
                    }
                }
            }
        }
        System.out.println(f[3][0]);
    }

    private static int mod(int x, int y) {
        return (x % y + y) % y;
    }
}
