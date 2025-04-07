package algorithm.lanqiao.w4.d4.t3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int N = 100010, P = 131;
    static final long Q = Long.MAX_VALUE;
    static char[] str = new char[N];
    // p的次方
    static long[] p = new long[N];
    // 前缀和哈希
    static long[] h = new long[N];

    public static void main(String[] args) throws Exception {
        int n = Reader.nextInt(), m = Reader.nextInt();
        // 后移
        str = (" " + Reader.next()).toCharArray();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 预处理p的n次方
            p[i] = p[i - 1] * P % Q;
            // 预处理前缀和
            h[i] = (h[i - 1] * P + str[i]) % Q;
        }

        int l1, r1, l2, r2;
        while (m-- > 0) {
            l1 = Reader.nextInt();
            r1 = Reader.nextInt();
            l2 = Reader.nextInt();
            r2 = Reader.nextInt();
            if (getHash(l1, r1) == getHash(l2 ,r2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static long getHash(int l, int r) {
        return (h[r] - h[l - 1] * p[r - l + 1]) % Q;
    }

    static class Reader {
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
}
