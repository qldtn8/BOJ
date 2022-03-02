package BJ.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크 {

    static int N;
    static int[][] synergy;

    public static void subSet(int nth, int flag) {
        if(nth == N/2) {
            System.out.println(Integer.toBinaryString(flag));
            return;
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        synergy = new int[N][N];

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                synergy[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        subSet(0, 0);


    }
}
