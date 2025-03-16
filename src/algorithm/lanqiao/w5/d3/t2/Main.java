package algorithm.lanqiao.w5.d3.t2;

import java.util.*;

public class Main {
    static final int N = 1010;
    static int[] arr = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}