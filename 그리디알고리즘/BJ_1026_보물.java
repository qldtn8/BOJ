package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1026_보물 {

    static int N;
    static int[] A;
    static Integer[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new Integer[N];

        StringTokenizer token1 = new StringTokenizer(br.readLine());
        StringTokenizer token2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token1.nextToken());
            B[i] = Integer.parseInt(token2.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, (o1, o2)->o2.compareTo(o1));

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += A[i]*B[i];
        }
        System.out.println(sum);
    }
}
