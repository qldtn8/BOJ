package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 에디터
 */
public class BJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder input = new StringBuilder(br.readLine());
        LinkedList<Character> str = new LinkedList<>();
        String line = br.readLine();
        for(int i = 0; i < line.length(); i++) {
            str.add(line.charAt(i));
        }
        int index = line.length();
        int command = Integer.parseInt(br.readLine());
        for(int i = 0; i < command; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            switch (token.nextToken()) {
                case "L" :
                    if(index != 0) index--;
                    break;
                case "D" :
                    if(index != str.size()) index++;
                    break;
                case "B" :
                    if(index != 0) str.remove(--index);
                    break;
                case "P" :
                    str.add(index++, token.nextToken().charAt(0));
                    break;
            }
        }

        StringBuilder output = new StringBuilder("");
        for(int i = 0; i < str.size(); i++) {
            output.append(str.get(i));
        }
        System.out.println(output);

    }
}
