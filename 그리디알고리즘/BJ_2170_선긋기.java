package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2170_선긋기 {

    static class Line implements Comparable<Line>{
        int x, y;
        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line o) {
            if(this.x != o.x) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Line> pq = new PriorityQueue<>();
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            pq.offer(new Line(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }


        int total = 0;
        Line curr = pq.poll();
        total += curr.y - curr.x;
        while(!pq.isEmpty()) {
            Line l = pq.poll();

            if(l.y <= curr.y) {
                continue;
            }

            if(l.x <= curr.y) {
                total += l.y - curr.y;
            } else {
                total += l.y - l.x;
            }

            curr = l;
        }
        System.out.println(total);
    }
}
