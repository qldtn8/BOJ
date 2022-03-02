package BJ.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11286_절대값힙 {

    static class Number implements Comparable<Number> {
        int x, abs;
        public Number(int x, int abs) {
            this.x = x;
            this.abs = abs;
        }
        @Override
        public int compareTo(Number o) {
            if(this.abs == o.abs)
                return Integer.compare(this.x, o.x);
            return Integer.compare(this.abs, o.abs);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Number> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            int abs = x;
            if(x < 0) abs *= -1;

            if(x != 0) {
                pq.offer(new Number(x, abs));
                continue;
            }

            if(pq.isEmpty()) {
                output.append("0\n");
            } else {
                Number min = pq.poll();
                output.append(min.x+"\n");
            }
        }
        System.out.println(output);
    }
}
