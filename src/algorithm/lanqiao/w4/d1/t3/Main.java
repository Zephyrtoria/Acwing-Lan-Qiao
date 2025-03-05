/**
 * @Author: Zephyrtoria
 * @CreateTime: 2025-03-05
 * @Description:
 * @Version: 1.0
 */

package algorithm.lanqiao.w4.d1.t3;

import java.util.*;

public class Main {
    static final int[] fx = {1, -1, 0, 0};
    static final int[] fy = {0, 0, 1, -1};

    private static class Pair {
        String ch;
        int dis;

        public Pair(String ch, int dis) {
            this.ch = ch;
            this.dis = dis;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replace(" ", "");
        System.out.println(bfs(input));
    }

    private static int bfs(String start) {
        String end = "12345678x";
        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start);
        queue.add(new Pair(start, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            if (end.equals(p.ch)) {
                return p.dis;
            }
            char[] cur = p.ch.toCharArray();
            int loc = 0;
            while (cur[loc] != 'x') {
                loc++;
            }
            int x = loc / 3, y = loc % 3;

            for (int i = 0; i < 4; i++) {
                int dx = x + fx[i], dy = y + fy[i];
                if (0 <= dx && dx < 3 && 0 <= dy && dy < 3) {
                    swap(cur, x, y, dx, dy);
                    String temp = toString(cur);
                    if (!visited.contains(temp)) {
                        queue.add(new Pair(temp, p.dis + 1));
                        visited.add(temp);
                    }
                    swap(cur, x, y, dx, dy);
                }
            }
        }
        return -1;
    }

    private static void swap(char[] arr, int x, int y, int dx, int dy) {
        char temp = arr[x * 3 + y];
        arr[x * 3 + y] = arr[dx * 3 + dy];
        arr[dx * 3 + dy] = temp;
    }

    private static String toString(char[] ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}