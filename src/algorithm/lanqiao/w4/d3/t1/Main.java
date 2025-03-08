/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-08
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w4.d3.t1;

import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] graph;

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

    public static void main(String[] args) throws Exception {
        int T = Reader.nextInt();
        for (int t = 0; t < T; t++) {
            int n = Reader.nextInt();
            int h = Reader.nextInt();
            int r = Reader.nextInt();
            // graph[0] 作为下表面，graph[n + 1] 作为上表面
            graph = new boolean[n + 2][n + 2];
            Point[] ps = new Point[n + 1];

            // 读入点
            for (int i = 1; i <= n; i++) {
                int x = Reader.nextInt();
                int y = Reader.nextInt();
                int z = Reader.nextInt();
                ps[i] = new Point(x, y, z);
            }

            // 建图
            // 是否与下表面连通
            for (int i = 1; i <= n; i++) {
                if (ps[i].z <= r) {
                    graph[0][i] = graph[i][0] = true;
                }
            }

            // 是否与上表面连通
            int dif = h - r;
            for (int i = 1; i <= n; i++) {
                if (ps[i].z >= dif) {
                    graph[n + 1][i] = graph[i][n + 1] = true;
                }
            }

            // 是否与其他点连通
            int d = r * 2;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (ps[i].dist(ps[j]) <= d) {
                        graph[i][j] = graph[j][i] = true;
                    }
                }
            }

            // 搜索是否能从0到n+1
            if (bfs(n)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n + 2];
        visited[0] = true;

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            if (cur == n + 1) {
                return true;
            }
            for (int i = 1; i <= n + 1; i++) {
                if (graph[cur][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
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