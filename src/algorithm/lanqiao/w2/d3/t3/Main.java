/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-22
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d3.t3;

import java.util.*;

public class Main {
    private static final int N = 100010;
    private static final int[] arr = new int[N];
    private static final int[] temp = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(mergeSort(0, n - 1));
    }

    private static long mergeSort(int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + right >> 1;
        long leftPart = mergeSort(left, mid);
        long rightPart = mergeSort(mid + 1, right);

        int i = left, j = mid + 1, k = 0;
        long res = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                res += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int u = 0, v = left; u < k; u++, v++) {
            arr[v] = temp[u];
        }
        return leftPart + rightPart + res;
    }
}