package BJ.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14465_소가길을건너간이유5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());

        // 수리가 필요한 신호등은 true
        boolean[] trafficLight = new boolean[N+1];
        for(int i = 0; i < B; i++) {
            trafficLight[Integer.parseInt(br.readLine())] = true;
        }

        int count = 0;  // 수리가 필요한 신호등 개수
        for(int i = 1; i <= K; i++) {
            if(trafficLight[i]) count++;
        }

        int min = count;
        int head = 1;
        for(int tail = K+1; tail < N+1; tail++) {
            if(trafficLight[tail]) count++;
            if(trafficLight[head++]) count--;
            min = Math.min(count, min);
        }
        System.out.println(min);
    }
}
