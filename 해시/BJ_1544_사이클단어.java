package BJ.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BJ_1544_사이클단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> words = new HashSet<>();
        outer: for(int i = 0; i < N; i++) {
            String word = br.readLine();
            Iterator<String> iter = words.iterator();
            while(iter.hasNext()) {
                String temp = iter.next();
                if(temp.length() != word.length()) {
                    continue;
                }

                if(temp.repeat(2).contains(word)) {
                    continue outer;
                }
            }
            words.add(word);
        }
        System.out.println(words.size());
    }
}
