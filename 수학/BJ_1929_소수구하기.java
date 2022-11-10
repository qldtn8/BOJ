package BJ.수학;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1929_소수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());

        boolean[] isNotPrime = new boolean[N+1];

        for(int i = 2; i <= N; i++) {
            if(i >= M && !isNotPrime[i]) bw.write(i+"\n");

            for(int j = 2; j*i <= N; j++)
                isNotPrime[i*j] = true;
        }

        bw.flush();
        bw.close();
    }
}
