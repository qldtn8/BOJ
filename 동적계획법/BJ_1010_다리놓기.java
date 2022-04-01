package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010_다리놓기 {

    static int T;
    static int R;
    static int N;

    public static int combination() {
        if(R == 0 || N == R) {
            return 1;
        }

        int[][] combi = new int[N+1][N+1];
        for(int n = 1; n < N+1; n++) {
            for(int r = 0; r < n+1; r++) {
                if(r == 0 || r == n) combi[n][r] = 1;
                else combi[n][r] = combi[n-1][r-1] + combi[n-1][r];
            }
        }
        return combi[N][R];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder output = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine());
            R = Integer.parseInt(token.nextToken());
            N = Integer.parseInt(token.nextToken());
            output.append(combination()+"\n");
        }
        System.out.println(output.toString());
    }
}
