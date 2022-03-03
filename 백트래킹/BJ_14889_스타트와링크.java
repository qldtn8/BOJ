package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크 {

    static int N;
    static int[][] arr;
    static int min;

    public static void combination(int nth, int start, int flag) {
        if(nth == N/2) {
            int teamA = 0;
            int teamB = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i != j) {
                        if((flag & 1 << i) != 0 && (flag & 1 << j) != 0) teamA += arr[i][j];
                        else if((flag & 1 << i) == 0 && (flag & 1 << j) == 0)  teamB += arr[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(teamA-teamB));
            return;
        }
        for(int i = start; i < N; i++) {
            if((flag & 1 << i) == 0) {
                combination(nth+1, i+1, flag | 1 << i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr= new int[N][N];

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        combination(1, 0, 1 << 0);
        System.out.println(min);

    }
}
