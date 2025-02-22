/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-22
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d3.t2;

import java.util.*;

public class Main {
    private static int N = 100010;
    private static int[] arr = new int[N];
    private static int[] temp = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

    private static void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + right >> 1;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
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
    }
}