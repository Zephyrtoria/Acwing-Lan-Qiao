/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-08
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w4.d3.t1;

import java.util.*;
import java.io.*;

public class Main2 {
    private static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double dist(Point o) {
            return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2) + Math.pow(z - o.z, 2));
        }
    }

    private static class Dsu {
        int[] parent;
        int n;

        public Dsu(int n) {
            this.n = n;
            parent = new int[n + 2];
            for (int i = 0; i <= n + 1; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void unite(int a, int b) {
            parent[find(a)] = find(b);
        }

        public boolean same(int a, int b) {
            return find(a) == find(b);
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Reader.nextInt();
        for (int t = 0; t < T; t++) {
            int n = Reader.nextInt();
            int h = Reader.nextInt();
            int r = Reader.nextInt();
            // parent[0] 作为下表面，parent[n + 1] 作为上表面，判断两个节点是否拥有同一个父节点
            Dsu dsu = new Dsu(n);

            // 读入点
            Point[] ps = new Point[n + 1];
            for (int i = 1; i <= n; i++) {
                int x = Reader.nextInt();
                int y = Reader.nextInt();
                int z = Reader.nextInt();
                ps[i] = new Point(x, y, z);
            }

            // 并查集生成
            // 是否与下表面连通
            for (int i = 1; i <= n; i++) {
                if (ps[i].z <= r) {
                    dsu.unite(i, 0);
                }
            }

            // 是否与上表面连通
            int dif = h - r;
            for (int i = 1; i <= n; i++) {
                if (ps[i].z >= dif) {
                    dsu.unite(i, n + 1);
                }
            }

            // 是否与其他点连通
            int d = r * 2;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (ps[i].dist(ps[j]) <= d) {
                        dsu.unite(i, j);
                    }
                }
            }

            // 判断是否能从0到n+1
            if (dsu.same(0, n + 1)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}

class Reader {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token = new StringTokenizer("");

    public static String nextLine() throws Exception {
        return br.readLine();
    }

    public static String next() throws Exception {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(nextLine());
        }
        return token.nextToken();
    }

    public static Integer nextInt() throws Exception {
        return Integer.parseInt(next());
    }
}