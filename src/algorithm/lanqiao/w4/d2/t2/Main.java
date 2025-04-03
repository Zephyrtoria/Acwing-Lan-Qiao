package algorithm.lanqiao.w4.d2.t2;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 110;
    static int[][] g = new int[N][N];
    static final int[] fx = {1, -1, 0, 0};
    static final int[] fy = {0, 0, 1, -1};
    static int r, c;

    public static void main(String[] args) throws Exception {
        int T = Reader.nextInt();
        for (int t = 1; t <= T; t++) {
            r = Reader.nextInt();
            c = Reader.nextInt();
            for (int i = 0; i < r; i++) {
                String input = Reader.next();
                for (int j = 0; j < c; j++) {
                    g[i][j] = input.charAt(j) - '0';
                }
            }
            System.out.printf("Case #%d:\n", t);
            int q = Reader.nextInt();
            for (int qq = 0; qq < q; qq++) {
                String choice = Reader.next();
                if ("Q".equals(choice)) {
                    int res = 0;
                    boolean[][] visited = new boolean[N][N];
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            if (g[i][j] == 1 && !visited[i][j]) {
                                res++;
                                dfs(i, j, visited);
                            }
                        }
                    }
                    System.out.println(res);
                } else {
                    int x = Reader.nextInt();
                    int y = Reader.nextInt();
                    int z = Reader.nextInt();
                    g[x][y] = z;
                }
            }
        }
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int dx = fx[i] + x, dy = fy[i] + y;
            if (0 <= dx && dx < r && 0 <= dy && dy < c && g[dx][dy] == 1 && !visited[dx][dy]) {
                dfs(dx, dy, visited);
            }
        }
    }
}

class Reader {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer to = new StringTokenizer("");

    public static String nextLine() throws Exception {
        return br.readLine();
    }

    public static String next() throws Exception {
        while (!to.hasMoreTokens()) {
            to = new StringTokenizer(nextLine());
        }
        return to.nextToken();
    }

    public static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }
}