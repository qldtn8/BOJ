package BJ.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_5525_IOIOI {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int index = 0;
        char prev = S.charAt(index);
        int length = 1;
        ArrayList<Integer> lengthes = new ArrayList<>();

        while(++index < M) {
            if(S.charAt(index) != prev) {
                length++;
            } else {
                if(length >= 3) {
                    if(length % 2 == 0 || prev == 'I')
                        lengthes.add(length);
                }
                length = 1;
            }

            if(index == M-1 && S.charAt(index) != prev) {
                if(length >= 3 && (length % 2 == 0 || prev == 'O'))
                    lengthes.add(length);
            }
            prev = S.charAt(index);
        }
        System.out.println(lengthes);

        int count = 0;
        for(int len : lengthes) {
            int len_N;
            if(len % 2 == 0) {
                len_N = len / 2 - 1;
            } else {
                len_N = (len - 1) / 2;
            }

            if(len_N >= N) {
                count += (len_N - N) + 1;
            }
        }
        System.out.println(count);
    }
}
