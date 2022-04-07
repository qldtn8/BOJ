package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1932_정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][];
        for(int i = 0; i < N; i++) {
            triangle[i] = new int[i+1];
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++) {
                triangle[i][j] = Integer.parseInt(token.nextToken());
                if(i != 0) {
                    int max = 0;
                    if(j < i) max = triangle[i-1][j];
                    if(j - 1 >= 0 && max < triangle[i-1][j-1])
                        max = triangle[i-1][j-1];
                    triangle[i][j] += max;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if(max < triangle[N-1][i]) max = triangle[N-1][i];
        }
        System.out.println(max);
    }
}
