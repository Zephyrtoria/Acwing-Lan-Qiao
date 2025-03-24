package algorithm.lanqiao.w1.d2.t4;
import java.util.*;

public class Main {
    static final int N = 100010;
    static int[] cnt = new int[N];
    static long[] s = new long[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextLong();
            s[i] += s[i - 1];
        }

        cnt[0] = 1;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int mod = (int) s[i] % k;
            // 先加上与Si模k相同的数
            res += cnt[mod];
            // 再递增
            cnt[mod]++;
        }
        System.out.println(res);
    }
}