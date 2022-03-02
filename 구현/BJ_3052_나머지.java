package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3052_나머지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] count = new int[42];
        for(int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            count[number%42]++;
        }

        int numOf = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                numOf++;
            }
        }
        System.out.println(numOf);
    }
}
