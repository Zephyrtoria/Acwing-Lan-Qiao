package algorithm.lanqiao.w1.d2.t6;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static final int N = 100010;
    static int[] a = new int[N], b = new int[N], c = new int[N];
    static int n;

    private static void read(int[] arr, Scanner sc) {
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        // 初始化两端，使得搜索时即使超出了范围，也可以进行定位
        arr[0] = -1;
        arr[n + 1] = 0x3f3f3f3f;
        Arrays.sort(arr, 1, n + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        read(a, sc);
        read(b, sc);
        read(c, sc);

        long res = 0;
        int bi, l, r, pos1, pos2;
        for (int i = 1; i <= n; i++) {
            bi = b[i];

            // 找A中第一个小于bi的数的下标
            l = 0;
            r = n + 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (a[mid] <= bi - 1) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            pos1 = l;

            // 找C中第一个大于bi的数的下标
            l = 0;
            r = n + 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (c[mid] >= bi + 1) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            pos2 = l;
            res += (long) pos1 * (n - pos2 + 1);
        }
        System.out.println(res);
    }
}
