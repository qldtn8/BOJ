package BJ.최소신장트리;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_9372_상근이의여행 {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            for(int i = 0; i < M; i++) {
                br.readLine();
            }
            bw.write(N-1+"\n");
        }
        bw.flush();
        bw.close();
    }
}
