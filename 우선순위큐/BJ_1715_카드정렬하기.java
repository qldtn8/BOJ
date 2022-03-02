package BJ.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1715_카드정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            pq.offer((long) Integer.parseInt(br.readLine()));
        }

        if(N == 1) {
            System.out.println(0);
            return;
        }

        long sum = 0;
        while(true) {
            long temp = pq.poll() + pq.poll();
            sum += temp;
            if(pq.isEmpty()) break;
            pq.offer(temp);
        }
        System.out.println(sum);
    }
}
