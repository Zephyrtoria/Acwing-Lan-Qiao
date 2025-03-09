/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-09
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w4.d4.t1;

import java.util.*;
import java.io.*;

public class Main {
    // 星系图
    static final int N = 110;
    static char[][] g = new char[N][N];
    static int n, m;
    // 当前搜索的星系中的星星数组
    static final int M = 170;
    static Pair[] p = new Pair[M];
    static int num;
    // 不同的星系的哈希值和数量
    static double[] hashVal = new double[30];
    static int cnt = 0;
    // eps
    static final double eps = 1e-8;

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static double getDist(Pair a, Pair b) {
            double dx = a.x - b.x, dy = a.y - b.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    // 计算哈希值
    public static double getHash() {
        // 距离哈希
        double sum = 0;
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                sum += Pair.getDist(p[i], p[j]);
            }
        }

        // 质心哈希（使用多个哈希避免碰撞）
        // 求质心
        double sx = 0, sy = 0;
        for (int i = 0; i < num; i++) {
            sx += p[i].x;
            sy += p[i].y;
        }
        sx /= num;
        sy /= num;
        for (int i = 0; i < num; i++) {
            double dx = p[i].x - sx, dy = p[i].y - sy;
            sum += Math.sqrt(dx * dx + dy * dy);
        }

        return sum;
    }

    // 通过哈希值得到星系编码
    public static char getId() {
        double val = getHash();
        for (int i = 0; i < cnt; i++) {
            if (Math.abs(hashVal[i] - val) < eps) {
                return (char) ('a' + i);
            }
        }
        hashVal[cnt++] = val;
        return (char) ('a' + cnt - 1);
    }

    // Flood fill
    public static void dfs(int a, int b) {
        p[num++] = new Pair(a, b);
        g[a][b] = '0';

        for (int x = a - 1; x <= a + 1; x++) {
            for (int y = b - 1; y <= b + 1; y++) {
                if (0 <= x && x < n && 0 <= y && y < m && g[x][y] == '1') {
                    dfs(x, y);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        m = Reader.nextInt();
        n = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            g[i] = Reader.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '1') {
                    // 清空上一个星系的数据
                    num = 0;
                    dfs(i, j);
                    char id = getId();
                    for (int k = 0; k < num; k++) {
                        g[p[k].x][p[k].y] = id;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%c", g[i][j]);
            }
            System.out.println();
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