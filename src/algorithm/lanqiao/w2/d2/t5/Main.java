package algorithm.lanqiao.w2.d2.t5;

import java.util.*;

public class Main {
    static final int N = 100010;
    static Note[] ns = new Note[N];
    static int[] count = new int[N];
    static boolean[] st = new boolean[N];

    static class Note implements Comparable<Note> {
        int ts, id;

        public Note(int ts, int id) {
            this.ts = ts;
            this.id = id;
        }

        @Override
        public int compareTo(Note p) {
            return ts - p.ts;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int ts, id;
        for (int i = 0; i < n; i++) {
            ts = sc.nextInt();
            id = sc.nextInt();
            ns[i] = new Note(ts, id);
        }

        // 按照时间排序
        Arrays.sort(ns, 0, n);
        // i为最早时间，j为最迟时间，构成了一个滑动窗口
        for (int i = 0, j = 0; i < n; i++) {
            // 判断区间两侧的时间是否超出了d，注意左闭右开，不取等号
            while (j < n && ns[j].ts - ns[i].ts < d) {
                // 累加点赞次数
                count[ns[j].id]++;
                j++;
            }

            // 如果该贴满足条件，记录状态
            if (count[ns[i].id] >= k) {
                st[ns[i].id] = true;
            }
            // 离开区间
            count[ns[i].id]--;
        }

        for (int i = 0; i < N; i++) {
            if (st[i]) {
                System.out.println(i);
            }
        }
    }
}