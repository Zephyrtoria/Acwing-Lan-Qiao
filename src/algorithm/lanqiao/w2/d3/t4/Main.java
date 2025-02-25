/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-25
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d3.t4;

import java.util.*;

public class Main {
    static final int N = 100010;
    static Pair[] nums = new Pair[N];
    static Pair[] temp = new Pair[N];
    static int[] sum = new int[N];

    private static class Pair {
        int id;
        int num;

        public Pair(int id, int num) {
            this.id = id;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[i] = new Pair(i, num);
        }
        mergeSort(0, n - 1);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) (1 + sum[i]) * (sum[i]) / 2;
        }
        System.out.println(result);
    }

    private static void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + right >> 1;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i].num <= nums[j].num) {
                // 统计在nums[i]之后比nums[i]小的数
                sum[nums[i].id] += j - mid - 1;
                temp[k++] = nums[i++];
            } else {
                // 统计在nums[j]之前比nums[j]大的数
                sum[nums[j].id] += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            // 统计在nums[i]之后比nums[i]小的数
            sum[nums[i].id] += j - mid - 1;
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            // 统计在nums[j]之前比nums[j]大的数
            sum[nums[j].id] += mid - i + 1;
            temp[k++] = nums[j++];
        }

        for (int u = 0, v = left; u < k; u++, v++) {
            nums[v] = temp[u];
        }
    }
}