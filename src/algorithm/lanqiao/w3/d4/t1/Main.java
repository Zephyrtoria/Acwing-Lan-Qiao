/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-28
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w3.d4.t1;

import java.util.*;
import java.io.*;


public class Main {
    static final int N = 60;
    static int[][] graph = new int[N][N];
    static int n, m;
    static final int[] fx = {1, -1, 0, 0};
    static final int[] fy = {0, 0, 1, -1};
    static int res = 0x3f3f3f3f;

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Point o) {
            return Math.abs(this.x - o.x) + Math.abs(this.y - o.y);
        }
    }

    public static void main(String[] args) throws Exception {
        n = Reader.nextInt();
        m = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            String input = Reader.nextLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'X') {
                    graph[i][j] = 1;
                }
            }
        }

        // 各自标记两个斑点，得到两个点集
        List<Point> p1 = new ArrayList<>();
        List<Point> p2 = new ArrayList<>();
        List<Point> group = p1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    dot(i, j, group);
                    group = p2;
                }
            }
        }

        // 从1号斑点出发，遍历该斑点上每一个点到达2号斑点的最短距离
        for (Point from : p1) {
            for (Point to : p2) {
                res = Math.min(res, from.distance(to));
            }
        }
        System.out.println(res - 1);
    }

    private static void dot(int x, int y, List<Point> group) {
        group.add(new Point(x, y));
        for (int i = 0; i < 4; i++) {
            int dx = fx[i] + x, dy = fy[i] + y;
            if (check(dx, dy) && graph[dx][dy] == 1) {
                graph[dx][dy] = 2;
                dot(dx, dy, group);
            }
        }
    }

    private static boolean check(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

class Reader {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");

    public static String nextLine() throws Exception {
        return reader.readLine();
    }

    public static String next() throws Exception {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }
}