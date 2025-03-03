/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-03
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w3.d5.t2;

import java.util.*;

public class Main {
    static int n;
    static int N = 20;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        backtracking(0, new ArrayList<>(), new boolean[N], new boolean[N], new boolean[N]);
    }

    private static void backtracking(int u, List<Integer> path, boolean[] col, boolean[] dg, boolean[] udg) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                int q = path.get(i);
                for (int j = 0; j < n; j++) {
                    if (j == q) {
                        System.out.print('Q');
                    } else {
                        System.out.print('.');
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] || dg[u - i + n] || udg[u + i]) {
                continue;
            }
            col[i] = dg[u - i + n] = udg[u + i] = true;
            path.add(i);
            backtracking(u + 1, path, col, dg, udg);
            path.remove(path.size() - 1);
            col[i] = dg[u - i + n] = udg[u + i] = false;
        }
    }
}