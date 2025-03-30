package algorithm.lanqiao.w3.d4.t3;

import java.util.*;

public class Main {
    static final int N = 100010;
    static LinkedList<Pair>[] g;
    static int n;
    static int res;
    static boolean[] visited = new boolean[N];

    static class Pair {
        int to, d;

        public Pair(int to, int d) {
            this.to = to;
            this.d = d;
        }
    }

    private static void add(int a, int b, int d) {
        g[a].add(new Pair(b, d));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new LinkedList<>();
        }
        int a, b, x;
        for (int i = 0; i < n - 1; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            x = sc.nextInt();
            add(a, b, x);
            add(b, a, x);
        }

        dfs(1);
        long result = (long) res * (11 + 10 + res) / 2;
        System.out.println((result));
    }

    private static int dfs(int cur) {
        // 不走回头路
        visited[cur] = true;
        // 以当前点为根节点，所能形成的最长通路
        ArrayList<Integer> dis = new ArrayList<>();
        // 找出最大的两条dfs路径
        for (Pair p : g[cur]) {
            int to = p.to;
            int cost = p.d;
            if (!visited[to]) {
                int d = cost + dfs(to);
                dis.add(d);
            }
        }
        Collections.sort(dis);
        Collections.reverse(dis);
        int sum = 0;
        int size = dis.size();
        if (size >= 2) {
            sum = dis.get(0) + dis.get(1);
        } else if (size == 1) {
            sum = dis.get(0);
        }
        res = Math.max(res, sum);
        if (size > 0) {
            return dis.get(0);
        }
        return 0;
    }
}
