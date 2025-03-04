/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-04
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w1.d1.t5;

import java.util.*;
import java.io.*;

public class Main {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    public static void main(String[] args) throws Exception {
        int n = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = Reader.nextInt();
            b[i] = Reader.nextInt();
        }

        // minV
        int minV = 1;
        for (int i = 0; i < n; i++) {
            minV = Math.max(minV, minBinary(a[i], b[i]));
        }

        // maxV
        int maxV = 0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            maxV = Math.min(maxV, maxBinary(a[i], b[i]));
        }
        System.out.printf("%d %d\n", minV, maxV);
    }

    private static int minBinary(int u, int v) {
        int left = 1, right = u;
        while (left < right) {
            int mid = left + right >> 1;
            if (u / mid <= v) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int maxBinary(int u, int v) {
        int left = 1, right = u;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (u / mid >= v) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
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