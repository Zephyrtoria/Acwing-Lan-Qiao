/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-04
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w1.d1.t6;

import java.util.*;
import java.io.*;

public class Main {
    static final int N = 100010;
    static int n;
    static int[] arr = new int[N];

    public static void main(String[] args) throws Exception {
        n = Reader.nextInt();
        int q = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = Reader.nextInt();
        }
        while (q-- > 0) {
            int k = Reader.nextInt();
            int left = findLeft(k);
            int right = findRight(k);
            System.out.printf("%d %d\n", left, right);
        }
    }

    private static int findLeft(int x) {
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (arr[left] == x) {
            return left;
        }
        return -1;
    }

    private static int findRight(int x) {
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (arr[left] == x) {
            return left;
        }
        return -1;
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