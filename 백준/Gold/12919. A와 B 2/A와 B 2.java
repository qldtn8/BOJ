import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        Set<String> visited = new HashSet<>();
        visited.add(T);

        Queue<String> queue = new LinkedList<>();
        queue.add(T);

        while(!queue.isEmpty()) {
            String word = queue.poll();

            if(word.equals(S)) {
                System.out.println(1);
                return;
            }

            if(word.length() - 1 < S.length()) continue;

            if(word.charAt(word.length()-1) == 'A' && !visited.contains(word.substring(0, word.length()-1))) {
                visited.add(word.substring(0, word.length()-1));
                queue.add(word.substring(0, word.length()-1));
            }

            if(word.charAt(0) == 'B') {
                String temp = new StringBuilder(word.substring(1)).reverse().toString();
                if(!visited.contains(temp)) {
                    visited.add(temp);
                    queue.add(temp);
                }
            }
        }
        System.out.println(0);
    }
}