/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-03
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w1.d1.t3;

import java.util.*;

public class Main {
    static final int N = 100010;
    static int[] s = new int[N];
    static int[] l = new int[N];
    static int n;
    static int len;

    private static class Pair implements Comparable<Pair> {
        int l, r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Pair o) {
            if (l == o.l) {
                return r - o.r;
            }
            return l - o.l;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        len = sc.nextInt();

        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        long left = 1, right = (long) (2 * 10e9);
        while (left < right) {
            // 最坏情况可能是2e9+2e9
            int mid = (int) (left + right >> 1);
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean check(int t) {
        // 区间合并
        // [1,len]，注意区间是离散的，pre.终点 + 1 = cur.起点 即为相交
        Pair[] ps = new Pair[N];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] <= t) {
                int d = t - s[i];
                int left = Math.max(1, l[i] - d);
                int right = (int) Math.min((long) len, (long) l[i] + d);
                ps[count++] = new Pair(left, right);
            }
        }
        Arrays.sort(ps, 0, count);

        int st = -1, ed = -1;
        for (int i = 0; i < count; i++) {
            if (ed + 1 < ps[i].l) {
                st = ps[i].l;
                ed = ps[i].r;
            } else {
                ed = Math.max(ed, ps[i].r);
            }
        }
        return st == 1 && ed == len;
    }
}