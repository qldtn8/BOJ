package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쇠막대기
 */
public class BJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int sum = 0;
        int pipe = 0;
        boolean isRaiser = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                if(str.charAt(i+1) == '(') {
                    isRaiser = false;
                    pipe++;
                } else {
                    isRaiser = true;
                }
            } else {
                if(isRaiser) {
                    sum += pipe;
                    isRaiser = false;
                } else {
                    sum++;
                    pipe--;
                }
            }
        }
        System.out.println(sum);
    }
}
