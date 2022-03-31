package BJ.우선순위큐;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13975_파일합치기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {

            int K = Integer.parseInt(br.readLine());
            StringTokenizer token = new StringTokenizer(br.readLine());
            int[] count = new int[100];
            for(int i = 0; i < K; i++) {
                count[Integer.parseInt(token.nextToken())]++;
            }

            for(int i = 1; i < 100; i++) {
                if(count[i] != 0) {
                    System.out.println(i + " " + count[i]);
                }
            }
        }
        bw.flush();
        bw.close();

        br.close();
    }
}
