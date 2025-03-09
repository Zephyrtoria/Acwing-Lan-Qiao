/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-09
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w4.d3.t3;

import java.util.*;

public class Main {
    private static class Dsu {
        int[] parent;
        int[] sizes;

        public Dsu(int n) {
            parent = new int[n + 1];
            sizes = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                sizes[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean same(int a, int b) {
            return find(a) == find(b);
        }

        public void unite(int a, int b) {
            int fa = find(a);
            int fb = find(b);
            if (fa == fb) {
                return;
            }
            parent[fa] = fb;
            sizes[fb] += sizes[fa];
        }

        public int count(int x) {
            return sizes[find(x)];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Dsu dsu = new Dsu(n);
        for (int i = 0; i < m; i++) {
            String input = sc.next();
            if (input.equals("C")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                dsu.unite(a, b);
            } else if (input.equals("Q1")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(dsu.same(a, b) ? "Yes" : "No");
            } else {
                int a = sc.nextInt();
                System.out.println(dsu.count(a));
            }
        }
    }
}