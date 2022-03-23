package BJ.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11651_좌표정렬하기2 {

    static class Position implements Comparable<Position>{
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if(this.y != o.y) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Position> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            pq.offer(new Position(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()) ));
        }

        StringBuilder output = new StringBuilder();
        while(!pq.isEmpty()) {
            Position p = pq.poll();
            output.append(p.x + " " + p.y + "\n");
        }
        System.out.println(output);
    }
}
