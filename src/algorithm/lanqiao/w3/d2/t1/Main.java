/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-26
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w3.d2.t1;

import java.util.*;

public class Main {
    static final int N = 5010;
    static Pair[] pairs = new Pair[N];

    static class Pair implements Comparable<Pair> {
        int l, r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.l == o.l) {
                return this.r - o.r;
            }
            return this.l - o.l;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            pairs[i] = new Pair(l, r);
        }

        // 排序
        Arrays.sort(pairs, 0, n);

        int left = pairs[0].l, right = pairs[0].r;
        int maxHasMilk = right - left, maxNoMilk = 0;
        for (int i = 1; i < n; i++) {
            if (pairs[i].l <= right) {
                // 连续挤奶
                right = Math.max(right, pairs[i].r);
                maxHasMilk = Math.max(maxHasMilk, right - left);
            } else {
                // 挤奶中断
                left = pairs[i].l;
                // 现在的左端点减去上一次的右端点
                maxNoMilk = Math.max(maxNoMilk, left - right);
                right = pairs[i].r;
                // 注意可能一段要比多段长
                maxHasMilk = Math.max(maxHasMilk, right - left);
            }
        }
        System.out.printf("%d %d\n", maxHasMilk, maxNoMilk);
    }

}