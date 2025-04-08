package algorithm.lanqiao.w7.d5.t2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 100010;
    static Pair[] p = new Pair[N];
    static int n;

    static class Pair implements Comparable<Pair> {
        int l, r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.l == l) {
                return r - o.r;
            }
            return l - o.l;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int l, r;
        for (int i = 0; i < n; i++) {
            l = sc.nextInt();
            r = sc.nextInt();
            p[i] = new Pair(l, r);
        }
        Arrays.sort(p, 0, n);

        l = Integer.MAX_VALUE;
        r = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (r < p[i].l) {
                res++;
                l = p[i].l;
                r = p[i].r;
            } else {
                l = p[i].l;
                r = Math.min(r, p[i].r);
            }
        }
        System.out.println(res);
    }
}
