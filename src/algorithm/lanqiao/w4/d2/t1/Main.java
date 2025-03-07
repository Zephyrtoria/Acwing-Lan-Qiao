/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-07
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w4.d2.t1;

import java.util.*;
import java.io.*;

public class Main {
    static final int[] fx = {1, -1, 0, 0, 1, 1, -1, -1};
    static final int[] fy = {0, 0, 1, -1, 1, -1, 1, -1};
    static final int N = 303;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        int T = Reader.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = Reader.nextInt();
            String[] inputs = new String[n];
            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                inputs[i] = Reader.nextLine();
            }

            // 雷:-1   [i][j]周围雷的数量:graph[i][j]
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (inputs[i].charAt(j) == '*') {
                        graph[i][j] = -1;
                    } else {
                        for (int x = i - 1; x <= i + 1; x++) {
                            for (int y = j - 1; y <= j + 1; y++) {
                                if (0 <= x && x < n && 0 <= y && y < n && inputs[x].charAt(y) == '*') {
                                    graph[i][j]++;
                                }
                            }
                        }
                    }
                }
            }

            // Flood Fill，填满所有为0的格子，统计数量
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 0) {
                        res++;
                        dfs(n, i, j);
                    }
                }
            }

            // 查看剩下来的，不与0相邻的数
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] != -1) {
                        res++;
                    }
                }
            }
            System.out.printf("Case #%d: %d\n", t, res);
        }
    }

    private static void dfs(int n, int x, int y) {
        if (graph[x][y] != 0) {
            graph[x][y] = -1;
            return;
        }

        graph[x][y] = -1;
        for (int i = 0; i < 8; i++) {
            int dx = x + fx[i];
            int dy = y + fy[i];
            if (0 <= dx && dx < n && 0 <= dy && dy < n && graph[dx][dy] != -1) {
                dfs(n, dx, dy);
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