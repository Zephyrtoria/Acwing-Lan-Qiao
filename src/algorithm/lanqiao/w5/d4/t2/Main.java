package algorithm.lanqiao.w5.d4.t2;

import java.util.*;

public class Main {
    static final int N = 1010;
    // 一维优化，相当于每次的i直接覆盖在上一次的i-1数组上
    // 因为每一次只会用到上一层的，不会用到更上面的数据
    // 且每次j-v[i]只会用在j之前的，当使用从大到小遍历时，当前修改不会影响到后面的答案
    // 所以可以使用滚动数组优化
    static int[] f = new int[N];
    static int[] w = new int[N];
    static int[] v = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        // dp
        for (int i = 1; i <= n; i++) {
            // 想清楚为什么要从大到小
            // 因为遍历到j时要使用上一层的j-v[i]，所以应当先遍历大的才能避免影响
            for (int j = V; j >= 0; j--) {
                if (j >= v[i]) {
                    // j >= v[i] 能够将第i个物品放入
                    // 不放入第i个物品, 放入第i个物品
                    f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
                }
            }
        }

        System.out.println(f[V]);
    }
}