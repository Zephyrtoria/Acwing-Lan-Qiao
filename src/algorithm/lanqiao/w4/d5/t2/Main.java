package algorithm.lanqiao.w4.d5.t2;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 100010;
    static int[] arr = new int[N];
    // 栈
    static int[] q = new int[N];
    static int top = -1;

    public static void main(String[] args) throws Exception {
        int n = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = Reader.nextInt();
        }

        for (int i = 0; i < n; i++) {
            // 栈空
            if (top == -1) {
                System.out.printf("%d ", -1);
            } else {
                // 应当维护单调递增的栈
                while (top >= 0 && q[top] >= arr[i]) {
                    top--;
                }
                System.out.printf("%d ", top == -1 ? -1 : q[top]);
            }
            q[++top] = arr[i];
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
