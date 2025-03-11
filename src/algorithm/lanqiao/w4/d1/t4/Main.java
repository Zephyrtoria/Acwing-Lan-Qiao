package algorithm.lanqiao.w4.d1.t4;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 1010;
    static int[][] graph = new int[N][N];
    static int n;
    static final int[] fx = {0, 0, 1, -1};
    static final int[] fy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        n = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            String input = Reader.next();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == '.') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1;
                }
            }
        }

        // 先找出已有陆地数量 id - 1为大小
        int id = 1;
        boolean[][] visited = new boolean[N][N];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (graph[i][j] == 1) {
                    id++;
                    search(i, j, visited, id);
                }
            }
        }

        // 吞没陆地 id -> -1
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (graph[i][j] > 0) {
                    sink(i, j);
                }
            }
        }

        // 搜寻剩下来的陆地
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (graph[i][j] > 0) {
                    set.add(graph[i][j]);
                }
            }
        }
        System.out.println(id - 1 - set.size());
    }

    // 搜寻不相连的陆地
    private static void search(int x, int y, boolean[][] visited, int id) {
        // 由于保证了四周必为海洋，所以不需要判断边界
        visited[x][y] = true;
        graph[x][y] = id;
        for (int i = 0; i < 4; i++) {
            int dx = x + fx[i], dy = y + fy[i];
            if (graph[dx][dy] == 1 && !visited[dx][dy]) {
                search(dx, dy, visited, id);
            }
        }
    }

    // 吞没陆地
    private static void sink(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int dx = x + fx[i], dy = y + fy[i];
            if (graph[dx][dy] == 0) {
                graph[x][y] = -1;
                return;
            }
        }
    }
}

class Reader {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tk = new StringTokenizer("");

    public static String line() throws Exception {
        return br.readLine();
    }

    public static String next() throws Exception {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(line());
        }
        return tk.nextToken();
    }

    public static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }
}