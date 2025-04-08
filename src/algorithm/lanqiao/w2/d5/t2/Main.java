package algorithm.lanqiao.w2.d5.t2;

import java.util.*;

public class Main {
    static final int N = 100010, MOD = (int) 1e9 + 7;
    static char[] str = new char[N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        str = sc.next().toCharArray();

        // 统计出现次数最多的字母
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (count.containsKey(str[i])) {
                count.put(str[i], count.get(str[i]) + 1);
            } else {
                count.put(str[i], 1);
            }
        }

        int maxi = 0;
        Set<Map.Entry<Character, Integer>> set = count.entrySet();
        for (Map.Entry<Character, Integer> e : set) {
            maxi = Math.max(e.getValue(), maxi);
        }
        int res = 0;
        for (Map.Entry<Character, Integer> e : set) {
            if (e.getValue() == maxi) {
                res++;
            }
        }
        System.out.println(qmi(res, n, MOD));
    }

    private static int qmi(int a, int k, int m) {
        int res = 1;
        while (k > 0) {
            if (k % 2 == 1) {
                res = (int) ((long) res * a % m);
            }
            a = (int) ((long) a * a % m);
            k >>= 1;
        }
        return res;
    }
}
