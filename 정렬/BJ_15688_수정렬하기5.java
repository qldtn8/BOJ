package BJ.정렬;

import java.io.*;

public class BJ_15688_수정렬하기5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[2000001];
        for(int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine()) + 1000000]++;
        }

        for(int i = 0; i < 2000001; i++) {
            if(count[i] != 0) {
                int num = i-1000000;
                for(int j = 0; j < count[i]; j++) {
                    bw.write( num +"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
