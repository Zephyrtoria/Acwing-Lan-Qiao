/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-26
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w3.d2.t2;

import java.util.*;

public class Main {
    static final int N = 100010;
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

        Arrays.sort(pairs, 0, n);
        int result = 1;
        int right = pairs[0].r;
        for (int i = 1; i < n; i++) {
            if (pairs[i].l <= right) {
                // 合并区间
                right = Math.max(right, pairs[i].r);
            } else {
                // 新区间
                result++;
                right = pairs[i].r;
            }
        }
        System.out.println(result);

    }
}