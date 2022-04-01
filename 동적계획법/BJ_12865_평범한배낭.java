package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭 {

    static class Stuff {
        int weight, value;
        public Stuff(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }

    static int N, K;
    static Stuff[] stuffs;
    static int[][] vales;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        stuffs = new Stuff[N+1];
        for(int i = 1; i < N+1; i++) {
            token = new StringTokenizer(br.readLine());
            stuffs[i] = new Stuff(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }

        vales = new int[N+1][K+1];

        for(int s = 1; s < N+1; s++) {
            Stuff temp = stuffs[s];
            for(int w = 1; w < K+1; w++) {
                if(temp.weight > w) {
                    vales[s][w] = vales[s-1][w];
                } else {
                    // 현재 물건을 담는다면?
                    int a = temp.value + vales[s-1][w-temp.weight];
                    // 현재 물건을 안담는다면?
                    int b = vales[s-1][w];

                    // 둘 중 최대값이 현재의 최적해!!
                    vales[s][w] = Math.max(a, b);
                }
            }
        }
        // N개의 물건을 모두 확인하고 최대가 Kkg일 때 최적해 가져오기
        System.out.println(vales[N][K]);
    }
}
