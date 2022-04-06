package BJ.LIS;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11053_가장긴증가하는부분수열4 {

    static int N;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        DP = new int[N];
        StringBuilder[] LIS = new StringBuilder[N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            DP[i] = 1;
            LIS[i] = new StringBuilder(arr[i] + " ");
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && DP[i] < 1 + DP[j]) {
                    DP[i] = 1 + DP[j];
                    LIS[i] = new StringBuilder(LIS[j]).append(arr[i]+" ");
                }
            }
            if(DP[max] < DP[i]) max = i;
        }
        System.out.println(DP[max]);
        System.out.println(LIS[max]);
    }
}
