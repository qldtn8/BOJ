package BJ;

import java.io.*;

/**
 * 영화감독 숌
 */
public class BJ_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int number = 666;
        while(true) {
            if(Integer.toString(number).contains("666")) {
                count++;
            }
            if(count == N) {
                break;
            }
            number++;
        }
        bw.write(Integer.toString(number));
        bw.flush();
        bw.close();
    }
}
