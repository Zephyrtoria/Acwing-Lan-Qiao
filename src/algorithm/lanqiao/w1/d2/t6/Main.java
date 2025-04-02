package algorithm.lanqiao.w1.d2.t6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 100010;
    static int[] a = new int[N], b = new int[N], c = new int[N];
    static int n;

    private static void read(int[] arr, Scanner sc) {
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr,1, n + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        read(a, sc);
        read(b, sc);
        read(c, sc);

        long res = 0;
        for (int i = 1, j = 1, k = 1; j <= n; j++) {
            // a中最后一个大于等于bi的数的下标
            while (i <= n && a[i] < b[j]) {
                i++;
            }
            // c中第一个大于bi的数的下标
            while (k <= n && c[k] <= b[j]) {
                k++;
            }
            res += (long) (i - 1) * (n - k + 1);
        }
        System.out.println(res);
    }
}
