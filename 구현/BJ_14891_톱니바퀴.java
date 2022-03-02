package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14891_톱니바퀴 {

    static String[] gears;
    static int[][] saw;

    public static void leftRotate(int nth, int direction) {
        if(nth - 1 >= 0 && gears[nth-1].charAt(saw[nth-1][1]) != gears[nth].charAt(saw[nth][0])) {
            leftRotate(nth-1, direction == 1 ? -1 : 1);
            rotation(nth - 1, direction == 1 ? -1 : 1);
        }
    }

    public static void rightRotate(int nth, int direction) {
        if(nth+1 < 4 && gears[nth].charAt(saw[nth][1]) != gears[nth+1].charAt(saw[nth+1][0])) {
            rightRotate(nth+1, direction == 1 ? -1 : 1);
            rotation(nth+1, direction == 1 ? -1 : 1);
        }
    }

    public static void rotation(int nth, int direction) {
        saw[nth][0] -= direction;
        saw[nth][1] -= direction;
        if(saw[nth][0] < 0) saw[nth][0] += 8;
        if(saw[nth][1] < 0) saw[nth][1] += 8;
        if(saw[nth][0] > 7) saw[nth][0] -= 8;
        if(saw[nth][1] > 7) saw[nth][1] -= 8;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gears = new String[4];
        saw = new int[4][2];
        for(int i = 0; i < 4; i++) {
            gears[i] = br.readLine();
            saw[i][0] = 6;
            saw[i][1] = 2;
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for(int k = 0; k < K; k++) {
            token = new StringTokenizer(br.readLine());
            int nth = Integer.parseInt(token.nextToken())-1;
            int direction = Integer.parseInt(token.nextToken());

            leftRotate(nth, direction);
            rightRotate(nth, direction);
            rotation(nth, direction);
        }

        int score = 0;
        for(int i = 0; i < 4; i++) {
            int index = saw[i][1] - 2;
            if(index < 0)
                index += 8;
            if(gears[i].charAt(index) == '1') {
                score += Math.pow(2, i);
            }
        }
        System.out.println(score);
    }
}
