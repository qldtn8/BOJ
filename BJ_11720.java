package BJ;

import java.io.*;

/**
 * 숫자의 합
 */
public class BJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int sum = 0;
        String line = br.readLine();
        for(int i = 0; i < T; i++) {
            sum += line.charAt(i) - '0';
        }

        bw.write("" + sum);
        bw.flush();
    }
}
