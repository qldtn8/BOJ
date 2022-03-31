package BJ.정렬;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11650_좌표정렬하기 {

    static class Position implements Comparable<Position> {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if(this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Position> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            pq.offer(new Position(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

        while(!pq.isEmpty()) {
            bw.write(pq.poll().toString()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
