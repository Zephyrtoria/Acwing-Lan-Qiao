/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-05
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w4.d1.t1;

import java.util.*;

public class Main {
    static final int N = 22;
    static int[] W = new int[3];
    static boolean[][][] visited = new boolean[N][N][N];
    static Set<Integer> results = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            W[i] = sc.nextInt();
        }

        bfs();
        for (Integer each : results) {
            System.out.printf("%d ", each);
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, W[2]});
        visited[0][0][W[2]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[0] == 0) {
                results.add(cur[2]);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j || cur[i] == 0) {
                        continue;
                    }
                    // i -> j
                    // 比较能够倒出的量和能够倒入的量
                    int[] li = new int[]{cur[0], cur[1], cur[2]};
                    int r = Math.min(li[i], W[j] - li[j]);
                    li[i] -= r;
                    li[j] += r;
                    int a = li[0], b = li[1], c = li[2];
                    if (!visited[a][b][c]) {
                        visited[a][b][c] = true;
                        queue.add(new int[]{a, b, c});
                    }
                }
            }
        }
    }
}