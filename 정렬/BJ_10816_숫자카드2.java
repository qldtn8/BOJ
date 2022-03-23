package BJ.정렬;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_10816_숫자카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] count = new int[20000001];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            count[10000000 + Integer.parseInt(token.nextToken())]++;
        }

        int M = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            bw.write(count[10000000+Integer.parseInt(token.nextToken())]+" ");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}
