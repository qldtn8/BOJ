package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11501_주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }

            int max = arr[N-1];
            long result = 0;
            for(int i = N-2; i >= 0; i--) {
                if(arr[i] >= max) {
                    max = arr[i];
                } else {
                    result += max - arr[i];
                }
            }
            output.append(result+"\n");
        }
        System.out.print(output);
    }
}
