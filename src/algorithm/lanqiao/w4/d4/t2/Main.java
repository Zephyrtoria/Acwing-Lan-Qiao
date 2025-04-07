package algorithm.lanqiao.w4.d4.t2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static final int N = 100003, INF = 0x3f3f3f3f;
    static LinkedList<Integer>[] a = new LinkedList[N];

    public static void main(String[] args) throws Exception {
        int n = Reader.nextInt();
        String opt;
        int x;
        while (n-- > 0) {
            opt = Reader.next();
            x = Reader.nextInt();
            switch (opt) {
                case "I":
                    insert(x);
                    break;
                case "Q":
                    System.out.println(query(x) ? "Yes" : "No");
                    break;
            }
        }
    }

    private static int hash(int x) {
        return (x % N + N) % N;
    }

    private static void insert(int x) {
        int h = hash(x);
        if (a[h] == null) {
            a[h] = new LinkedList<>();
        }
        for (Integer i : a[h]) {
            if (i == x) {
                return;
            }
        }
        a[h].add(x);
    }

    private static boolean query(int x) {
        int h = hash(x);
        if (a[h] == null) {
            return false;
        }
        for (Integer i : a[h]) {
            if (i == x) {
                return true;
            }
        }
        return false;
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
