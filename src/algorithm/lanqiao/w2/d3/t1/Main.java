/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-22
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d3.t1;

import java.util.*;

public class Main {
    private static final int MOD = 99999997;
    private static final int N = 100010;
    private static final Integer[] a = new Integer[N];
    private static final Integer[] b = new Integer[N];
    private static final Integer[] c = new Integer[N];
    private static final Integer[] p = new Integer[N];
    private static final Integer[] temp = new Integer[N];
    private static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }

        // 离散化
        discrete(a);
        discrete(b);

        // 二次映射
        // a -> c
        for (int i = 1; i <= n; i++) {
            c[a[i]] = i;
        }
        // c -> b
        for (int i = 1; i <= n; i++) {
            b[i] = c[b[i]];
        }

        // 计算逆序对
        System.out.println(mergeSort(1, n));
    }

    // 离散化
    private static void discrete(Integer[] w) {
        // 初始化下标
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        Arrays.sort(p, 1, n + 1, (x, y) -> {
            return w[x] - w[y];
        });
        for (int i = 1; i <= n; i++) {
            w[p[i]] = i;
        }
    }

    // 求逆序对
    private static long mergeSort(int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + end >> 1;
        long leftPart = mergeSort(start, mid);
        long rightPart = mergeSort(mid + 1, end);

        int i = start, j = mid + 1, k = 0;
        long res = 0;
        while (i <= mid && j <= end) {
            if (b[i] <= b[j]) {
                temp[k++] = b[i++];
            } else {
                temp[k++] = b[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[k++] = b[i++];
        }
        while (j <= end) {
            temp[k++] = b[j++];
        }

        for (int u = 0, v = start; u < k; u++, v++) {
            b[v] = temp[u];
        }

        return (leftPart + rightPart + res) % MOD;
    }
}