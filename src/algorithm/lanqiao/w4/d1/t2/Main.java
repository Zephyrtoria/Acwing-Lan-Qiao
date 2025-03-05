/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-05
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w4.d1.t2;

import java.util.*;

public class Main {
    static final int N = 110;
    static int[][] graph = new int[N][N];
    static boolean[][] visited = new boolean[N][N];
    static int n, m;
    static final int[] fx = new int[] {0, 0, 1, -1};
    static final int[] fy = new int[] {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int res = bfs();
        System.out.println(res);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 0});
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            System.out.println(Arrays.toString(cur));
            if (cur[0] == n && cur[1] == m) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int dx = cur[0] + fx[i];
                int dy = cur[1] + fy[i];
                if (1 <= dx && dx <= n && 1 <= dy && dy <= m && !visited[dx][dy] && graph[dx][dy] == 0) {
                    visited[dx][dy] = true;
                    queue.add(new int[]{dx, dy, cur[2] + 1});
                }
            }
        }
        return -1;
    }
}