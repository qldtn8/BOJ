package BJ.정렬;

import java.io.*;

public class BJ_11931_수정렬하기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        boolean[] count = new boolean[2000001];
        for(int i = 0; i < N; i++) {
            count[1000000 + Integer.parseInt(br.readLine())] = true;
        }
        br.close();
        for(int i = 2000000; i >= 0; i--) {
            if(count[i]) {
                bw.write(i-1000000 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
