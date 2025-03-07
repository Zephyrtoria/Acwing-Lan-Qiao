/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-07
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w4.d3.t2;

import java.util.*;
import java.io.*;

public class Main {
    private static class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
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
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        DSU d = new DSU(n);
        for (int i = 0; i < m; i++) {
            char ch = Reader.next().charAt(0);
            int a = Reader.nextInt();
            int b = Reader.nextInt();
            if (ch == 'M') {
                d.unite(a, b);
            } else {
                System.out.println(d.same(a, b) ? "Yes" : "No");
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

    public static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }
}