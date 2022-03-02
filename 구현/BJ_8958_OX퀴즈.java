package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8958_OX퀴즈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String line = br.readLine();
            int score = 0;
            int total = 0;
            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == 'O') {
                    total += ++score;
                } else {
                    score = 0;
                }
            }
            output.append(total+"\n");
        }
        System.out.println(output);
    }
}
