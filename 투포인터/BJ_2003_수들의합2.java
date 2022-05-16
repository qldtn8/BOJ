package BJ.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003_수들의합2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] A = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(token.nextToken());

        int i, j;
        i = j = 0;

        int sum = 0;
        int count = 0;

        while(i < N) {
            if(i == j) {
                j++;
                sum = A[i];
                continue;
            }

            if(sum < M) {
                if(j == N) {
                    j = ++i;
                    continue;
                }
                sum += A[j++];
            } else {
                if(sum == M) count++;
                sum -= A[i++];
            }
        }

        System.out.println(count);
    }
}
