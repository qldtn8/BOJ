package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10819_차이를최대로 {

    static int N;
    static int[] arr;
    static int max;

    /**
     *
     * @param nth 몇 번째 선택인지
     * @param flag visited
     * @param pre 이전에 선택된 값
     * @param sum 지금까지의 더해진 값
     */
    public static void permutation(int nth, int flag, int pre, int sum) {
        if(nth == N) {
            if(max < sum) {
                max = sum;
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if((flag & 1 << i) == 0) {
                permutation(nth+1, flag | 1 << i, arr[i], sum + Math.abs(pre - arr[i]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        for(int i = 0; i < N; i++) {
            permutation(1, 1 << i, arr[i], 0);
        }
        System.out.println(max);
    }
}
