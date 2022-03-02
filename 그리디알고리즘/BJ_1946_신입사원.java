package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1946_신입사원 {

    static int T;
    static int N;
    static int[][] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder output = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            score = new int[N][2];

            for(int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                score[i][0] = Integer.parseInt(token.nextToken());
                score[i][1] = Integer.parseInt(token.nextToken());
            }
            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0]-o1[0];
                }
            });
            int temp = Integer.MAX_VALUE;
            for(int i = score.length-1; i >= 0; i--) {
                if(temp > score[i][1]) {
                    temp = score[i][1];
                } else {
                    N--;
                }
            }
            output.append(N+"\n");
        }
        System.out.println(output);
    }
}
