package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14719_빗물 {

    static int H, W;
    static int[] blocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        H = Integer.parseInt(token.nextToken());
        W = Integer.parseInt(token.nextToken());

        blocks = new int[W];
        token = new StringTokenizer(br.readLine());

        int maxIdx = 0;
        for(int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(token.nextToken());
            if(blocks[maxIdx] < blocks[i]) {
                maxIdx = i;
            }
        }

        int total = 0;

        int maxHeight = blocks[0];
        for(int i = 1; i <= maxIdx; i++) {
            if(maxHeight > blocks[i]) {
                total += maxHeight-blocks[i];
            } else
                maxHeight = blocks[i];
        }

        maxHeight = blocks[W-1];
        for(int i = W-2; i >= maxIdx; i--) {
            if(maxHeight > blocks[i]) {
                total += maxHeight-blocks[i];
            } else
                maxHeight = blocks[i];
        }
        System.out.println(total);
    }
}
