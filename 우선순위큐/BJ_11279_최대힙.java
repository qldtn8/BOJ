package BJ.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11279_최대힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o2, o1));
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x != 0) {
                pq.offer(x);
                continue;
            }

            if(pq.isEmpty()) {
                output.append("0\n");
            } else {
                output.append(pq.poll()+"\n");
            }
        }
        System.out.println(output);
    }
}
