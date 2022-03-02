package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399_ATM {

    static int N;
    static int[] waitMinutes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        waitMinutes = new int[N];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            waitMinutes[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(waitMinutes);

        int temp = 0;
        int total = 0;
        for(int i = 0; i < N; i++) {
            temp += waitMinutes[i];
            total += temp;
        }
        System.out.println(total);
    }
}
