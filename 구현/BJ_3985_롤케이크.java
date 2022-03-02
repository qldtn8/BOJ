package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3985_롤케이크 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] rollCake = new int[L];

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[N];

        int expectMax = Integer.MIN_VALUE;
        int expectMaxIdx = -1;
        StringTokenizer token;
        for(int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(token.nextToken());
            int k = Integer.parseInt(token.nextToken());
            if(k-p > expectMax) {
                expectMax = k-p;
                expectMaxIdx = i;
            }

            for(int j = p-1; j <= k-1; j++) {
                if(rollCake[j] == 0) {
                    rollCake[j] = i;
                    count[i-1]++;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i = 0; i < count.length; i++) {
            if(max < count[i]) {
                max = count[i];
                maxIdx = i+1;
            }
        }
        System.out.println(expectMaxIdx+"\n"+maxIdx);
    }
}
