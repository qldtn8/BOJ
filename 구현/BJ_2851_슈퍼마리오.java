package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2851_슈퍼마리오 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = 0;
        for(int i = 0; i < 10; i++) {
            int mushroom = Integer.parseInt(br.readLine());
            if(Math.abs(100 - score) >= Math.abs(100 - (score+mushroom))) {
                score += mushroom;
            } else {
                break;
            }
        }
        System.out.println(score);
    }
}
