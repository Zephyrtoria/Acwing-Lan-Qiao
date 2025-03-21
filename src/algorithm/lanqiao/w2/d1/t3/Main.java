package algorithm.lanqiao.w2.d1.t3;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 1010;
    static int[][] dif = new int[N][N];

    public static void main(String[] args) throws Exception {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int q = Reader.nextInt();
        int x;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                x = Reader.nextInt();
                insert(i, j, i, j, x);
            }
        }

        int x1, y1, x2, y2, c;
        while (q-- > 0) {
            x1 = Reader.nextInt();
            y1 = Reader.nextInt();
            x2 = Reader.nextInt();
            y2 = Reader.nextInt();
            c = Reader.nextInt();
            insert(x1, y1, x2, y2, c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dif[i][j] +=  dif[i - 1][j] + dif[i][j - 1] - dif[i - 1][j - 1];
                Writer.write(dif[i][j] + " ");
            }
            Writer.write("\n");
        }

        Writer.flush();
        Writer.close();
    }

    private static void insert(int x1, int y1, int x2, int y2, int c) {
        dif[x1][y1] += c;
        dif[x2 + 1][y1] -= c;
        dif[x1][y2 + 1] -= c;
        dif[x2 + 1][y2 + 1] += c;
    }

    private static BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static class Reader {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tk = new StringTokenizer("");

        public static String nextLine() throws Exception {
            return br.readLine();
        }

        public static String next() throws Exception {
            while (!tk.hasMoreTokens()) {
                tk = new StringTokenizer(nextLine());
            }
            return tk.nextToken();
        }

        public static int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}