package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305_주유소 {

    static int N;
    static int[] distance;
    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        distance = new int[N];
        costs = new int[N];

        StringTokenizer token1 = new StringTokenizer(br.readLine());
        StringTokenizer token2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            if(i != N-1) distance[i] = Integer.parseInt(token1.nextToken());
            costs[i] = Integer.parseInt(token2.nextToken());
        }

        long result = 0; // 비용
        for(int i = 0; i < N-1; i++) {
            int minIdx = i;
            for(int j = i+1; j < N; j++) {
                if(costs[minIdx] > costs[j]) {
                    minIdx = j;
                    break;
                }
            }

            if(minIdx == i) minIdx = N-1;
            int totalDistance = 0;
            for(int j = i; j < minIdx; j++) {
                totalDistance += distance[j];
            }
            result += ((long)totalDistance) * costs[i];
            i = minIdx-1;
        }
        System.out.println(result);
    }
}
