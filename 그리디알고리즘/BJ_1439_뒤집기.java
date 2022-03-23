package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1439_뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] count = new int[2];
        int curr = line.charAt(0);
        count[curr - 48]++;
        for(int i = 1; i < line.length(); i++) {
            if(curr != line.charAt(i)) {
                curr = line.charAt(i);
                count[curr - 48]++;
            }
        }

        System.out.println(Math.min(count[0],count[1]));
    }
}
