package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971_외판원순회2 {

    static int N;
    static int[][] arr;
    static int MIN;
    static int start;
    static int endN;

    public static void permutation(int toChoose, int current, int cost, int flag) {
        if(cost > MIN) {
            return;
        }
        if(toChoose == 0) {
            if(arr[current][start] != 0) MIN = Math.min(MIN, cost+arr[current][start]);
            return;
        }
        for(int i = 0; i < N; i++) {
            if((flag & 1 << i) == 0 && arr[current][i] != 0) {
                permutation(toChoose-1, i, cost + arr[current][i], flag | 1 << i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        MIN = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            start = i;
            permutation(N-1, i, 0, 1 << i);
        }
        System.out.println(MIN);
    }
}
