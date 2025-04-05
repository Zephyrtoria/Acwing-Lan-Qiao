package algorithm.lanqiao.w2.d1.t4;
import java.util.*;
import java.io.*;
public class Main {
    static final int N = 2010;
    static int[][] d = new int[N][N];

    public static void main(String[] args) throws Exception{
        int n = Reader.nextInt(), m = Reader.nextInt();

        int x1, y1, x2, y2;
        while (m-- > 0) {
            x1 = Reader.nextInt();
            y1 = Reader.nextInt();
            x2 = Reader.nextInt();
            y2 = Reader.nextInt();
            add(x1, y1, x2, y2, 1);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] += d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1];
                bw.write(d[i][j] % 2 == 0 ? '0' : '1');
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void add(int x1, int y1, int x2, int y2, int c) {
        d[x1][y1] += c;
        d[x1][y2 + 1] -= c;
        d[x2 + 1][y1] -= c;
        d[x2 + 1][y2 + 1] += c;
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static class Reader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");

        static String nextLine() throws IOException{// 读取下一行字符串
            return reader.readLine();
        }

        static String next() throws IOException {// 读取下一个字符串
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {// 读取下一个int型数值
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {// 读取下一个double型数值
            return Double.parseDouble(next());
        }
    }
}
