/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-02-22
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w2.d2.t2;

import java.util.*;

public class Main {
    private static final int N = 100010;
    private static int[] arr = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(noDuplicate(n));
    }

    private static int noDuplicate(int n) {
        boolean[] existed = new boolean[N];
        int res = 0;
        for (int slow = 0, fast = 0; fast < n; fast++) {
            while (slow < fast && existed[arr[fast]]) {
                existed[arr[slow]] = false;
                slow++;
            }
            existed[arr[fast]] = true;
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }
}
