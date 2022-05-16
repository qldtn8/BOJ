package BJ.플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11049_행렬곱셈순서 {

    static class Matrix {
        int n, m;
        public Matrix(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Matrix[][] matrix = new Matrix[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            matrix[i][i] = new Matrix(n, m);
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                if(i == k) continue;
                for(int j = i+1; j < N; j++) {
                    if(i == j || k == j) continue;

                    
                }
            }
        }

    }
}
