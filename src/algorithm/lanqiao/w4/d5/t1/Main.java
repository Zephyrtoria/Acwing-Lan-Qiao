package algorithm.lanqiao.w4.d5.t1;

import java.util.*;

public class Main {
    static final int N = 3005;
    // 高度
    static int[][] h = new int[N][N];
    static int R, C;
    // 单调栈
    static int[] stk = new int[N];
    static int top;
    static int[] lmax = new int[N];
    static int[] rmax = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        int P = sc.nextInt();
        for (int i = 0; i < P; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            h[x - 1][y - 1] = -1;
        }
        // 初始化高度
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (h[i][j] == -1) {
                    h[i][j] = 0;
                } else {
                    h[i][j] = i == 0 ? 1 : h[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.printf("%d ", h[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // 从上到下，将问题分解为n个“直方图中的最大矩形”
        int res = 0;
        for (int i = 0; i < R; i++) {
            res = Math.max(work(i), res);
        }
        System.out.println(res);
    }

    private static int work(int row) {
        int[] temp = h[row];
        // lmax
        top = -1;
        for (int i = 0; i < C; i++) {
            while (top >= 0 && temp[stk[top]] >= temp[i]) {
                top--;
            }
            lmax[i] = top == -1 ? i : i - stk[top] - 1;
            stk[++top] = i;
        }

        // rmax
        top = -1;
        for (int i = C - 1; i >= 0; i--) {
            while (top >= 0 && temp[stk[top]] >= temp[i]) {
                top--;
            }
            rmax[i] = top == -1 ? C - 1 - i : stk[top] - i - 1;
            stk[++top] = i;
        }

        int res = 0;
        for (int i = 0; i < C; i++) {
            res = Math.max(res, temp[i] * (lmax[i] + rmax[i] + 1));
        }
        return res;
    }
}