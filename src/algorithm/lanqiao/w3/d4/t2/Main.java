package algorithm.lanqiao.w3.d4.t2;

import java.util.*;

public class Main {
    static final int N = 100010;
    // 邻接表
    static int[] h = new int[N];
    // 链表data
    static int[] e = new int[N * 2];
    // 链表next指针
    static int[] ne = new int[N * 2];
    static int idx, n, res;
    static boolean[] visited = new boolean[N];

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(h, -1);
        n = sc.nextInt();
        // 注意是n-1条边
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 由树的定义，必然不存在环
            add(a, b);
            add(b, a);
        }

        // dfs，随便选取一个起点开始
        res = N;
        dfs(1);
        System.out.println(res);
    }

    private static int dfs(int u) {
        visited[u] = true;
        // 除了“来时路”的其他所有点的总和，包括本身
        int sum = 1;
        // 统计其他连通块中点数的最大值
        int num = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            // i为指针，j才是数据
            int j = e[i];
            if (!visited[j]) {
                // 得到以节点i为根的子树所拥有的节点个数
                int d = dfs(j);
                // 维护最大连通子图的节点数
                num = Math.max(num, d);
                sum += d;
            }
        }

        // 因为每个节点都是从另一个节点调用dfs过来的（起点看成从虚空节点来的）
        // 所以每个节点都只能去搜索非“来时路”，所以需要n - sum来得到来时路的点数
        num = Math.max(num, n - sum);

        // 更新全局答案
        res = Math.min(res, num);

        // 返回的是以u为根节点所拥有的节点个数
        return sum;
    }

}