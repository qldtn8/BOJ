package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 최댓값
 */
public class BJ_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[9];
        for(int i = 0; i < 9; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        for(int i = 1; i < 9; i++) {
            if(list[max] < list[i]) {
                max = i;
            }
        }

        System.out.println(list[max] + "\n" + (max+1));
    }
}
