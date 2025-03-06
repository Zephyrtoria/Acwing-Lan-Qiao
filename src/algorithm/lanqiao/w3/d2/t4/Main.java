/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-06
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w3.d2.t4;

import java.util.*;

public class Main {
    static final int N = 100010;
    static int[] l = new int[N];
    static int[] s = new int[N];
    static int n, len;

    private static class Pair implements Comparable<Pair> {
        int st, ed;

        public Pair(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Pair o) {
            if (st == o.st) {
                return ed - o.ed;
            }
            return st - o.st;
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

        int left = 1, right = 2 * len;
        while (left < right) {
            int mid = (int)((long)left + right >> 1);
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean check(int t) {
        Pair[] ps = new Pair[N];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] <= t) {
                long dif = t - s[i];
                ps[count++] = new Pair(Math.max(1, (int) (l[i] - dif)), Math.min(len, (int) (l[i] + dif)));
            }
        }

        Arrays.sort(ps, 0, count);
        int st = -1, ed = -1;
        for (int i = 0; i < count; i++) {
            if (ed < ps[i].st - 1) {
                st = ps[i].st;
                ed = ps[i].ed;
            } else {
                ed = Math.max(ed, ps[i].ed);
            }
        }
        return st == 1 && ed == len;
    }
}