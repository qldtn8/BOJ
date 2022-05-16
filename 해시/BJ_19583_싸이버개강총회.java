package BJ.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_19583_싸이버개강총회 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        String S = token.nextToken();
        String E = token.nextToken();
        String Q = token.nextToken();

        int count = 0;
        Set<String> set = new HashSet<>();
        String line;
        while((line = br.readLine()) != null) {
            token = new StringTokenizer(line);
            String t = token.nextToken();
            String name = token.nextToken();

            if(t.compareTo(S) <= 0) {
                if(!set.contains(name))
                    set.add(name);
            }
            else if(t.compareTo(E) >= 0 && t.compareTo(Q) <= 0) {
                if(set.contains(name)) {
                    count++;
                    set.remove(name);
                }
            }
        }
        System.out.println(count);
    }
}
