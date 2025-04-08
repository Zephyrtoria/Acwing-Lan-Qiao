package algorithm.lanqiao.w6.d4.t4;

import java.util.*;

public class Main {
    private static class Pair {
        long base, exp;

        public Pair(long base, long exp) {
            this.base = base;
            this.exp = exp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        List<Pair> divided = divide(x);
        long res = 1;
        // 判断分解的质因数指数的奇偶性
        for (Pair p : divided) {
            if (p.exp % 2 == 1) {
                res *= p.base;
            }
        }
        System.out.println(res);
    }

    private static List<Pair> divide(long x) {
        List<Pair> res = new ArrayList<>();
        int s;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                s = 0;
                while (x % i == 0) {
                    x /= i;
                    s++;
                }
                res.add(new Pair(i, s));
            }
        }
        if (x > 1) {
            res.add(new Pair(x, 1));
        }
        return res;
    }
}
