package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_8980_택배 {

    static class Box implements Comparable<Box>{
        int from, to;
        int weight;

        public Box(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Box o) {
            if(this.from != o.from) {
                return o.from - this.from;
            }
            return o.to - this.to;
        }
    }

    static int N;
    static int maxWeight;

    static int M;
    static PriorityQueue<Box> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        maxWeight = Integer.parseInt(token.nextToken());

        M = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            pq.offer(new Box(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

        int[] weight = new int[N];
        int total = 0;
        while(!pq.isEmpty()) {
            Box box = pq.poll();
            System.out.println(box.from + " -> " + box.to + " weight " + box.weight);
            int minWeight = box.weight;
            for(int i = box.from; i < box.to; i++) {
                if(weight[i] + minWeight > maxWeight) {
                    minWeight = maxWeight - weight[i];
                }
            }
            System.out.println(minWeight+"\n\n");
            if(minWeight == 0) continue;

            total += minWeight;
            for(int i = box.from; i < box.to; i++) {
                weight[i] += minWeight;
            }
        }
        System.out.println(total);

    }
}




