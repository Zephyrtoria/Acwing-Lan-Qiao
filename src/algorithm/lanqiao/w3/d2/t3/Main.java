/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-06
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w3.d2.t3;

import java.util.*;
import java.io.*;

public class Main {
    static final int M = 10010;
    static Pair[] pr = new Pair[M];

    private static class Pair implements Comparable<Pair> {
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            pr[i] = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(pr, 0, m);
        int length = 0;
        int left = pr[0].l, right = pr[0].r;
        for (int i = 1; i < m; i++) {
            if (pr[i].l <= right) {
                right = Math.max(right, pr[i].r);
            } else {
                length += right - left + 1;
                left = pr[i].l;
                right = pr[i].r;
            }
        }
        length += right - left + 1;
        System.out.println(L - length + 1);
    }
}