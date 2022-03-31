package BJ.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_1377_버블소트 {

    static class Num {
        int idx, num;
        public Num(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Num> pq = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                if(o1.num == o2.num) {
                    return o1.idx - o2.idx;
                } return o1.num - o2.num;
            }
        });

        for(int i = 0; i < N; i++) {
            Num num = new Num(i, Integer.parseInt(br.readLine()));
            pq.offer(num);
        }

        int index = 0;
        int ans = 0;
        while(!pq.isEmpty()) {
            Num num = pq.poll();
            if(ans < num.idx - index) {
                ans = num.idx - index;
            }
            index++;
        }
        System.out.println(ans+1);
    }
}
