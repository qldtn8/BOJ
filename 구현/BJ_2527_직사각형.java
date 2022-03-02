package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2527_직사각형 {

    static class Rectangle implements Comparable<Rectangle> {
        int x, y;
        int p, q;
        public Rectangle(int x, int y, int p, int q) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.q = q;
        }
        @Override
        public int compareTo(Rectangle o) {
            if(this.x != o.x) {
                return Integer.compare(this.x, o.x);
            } else if(this.y != o.y) {
                return Integer.compare(this.y, o.y);
            } else if(this.p != o.p) {
                return Integer.compare(this.p, o.p);
            } else {
                return Integer.compare(this.q, o.q);
            }
        }
    }

    static PriorityQueue<Rectangle> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        pq = new PriorityQueue<>();

        StringTokenizer token;
        for(int t = 0; t < 4; t++) {
            token = new StringTokenizer(br.readLine());
            Rectangle r1 = new Rectangle(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
            Rectangle r2 = new Rectangle(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));

            pq.offer(r1);
            pq.offer(r2);
            r1 = pq.poll();
            r2 = pq.poll();

            if(r1.p < r2.x || r1.q < r2.y || r1.y > r2.q) {
                output.append("d");
            } else if((r1.p == r2.x && r1.q == r2.y) || (r1.p == r2.x && r1.y == r2.q)) {
                output.append("c");
            } else if(r1.q == r2.y || r1.y == r2.q || r1.p == r2.x) {
                output.append("b");
            } else {
                output.append("a");
            }
            output.append("\n");
        }
        System.out.println(output.substring(0, output.length()-1));
    }
}
