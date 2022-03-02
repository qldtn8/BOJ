package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1316_그룹단어체커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int n = 0; n < N; n++) {
            boolean[] check = new boolean['z'-'a'+1];
            String word = br.readLine();

            boolean isGroupWord = true;
            char current = word.charAt(0);
            check[current - 'a'] = true;
            for(int i = 1; i < word.length(); i++) {
                if(current != word.charAt(i)) {
                    if(check[word.charAt(i)-'a']) {
                        isGroupWord = false;
                        break;
                    }
                    current = word.charAt(i);
                    check[current - 'a'] = true;
                }
            }
            if(isGroupWord) count++;
        }
        System.out.println(count);
    }
}
