package BJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 단어 뒤집기
 */
public class BJ_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            Stack<String> stack = new Stack<>();
            String line = br.readLine();
            StringTokenizer token = new StringTokenizer(line);

            while(token.hasMoreTokens()) {
                String word = token.nextToken();
                for(int j = 0; j < word.length(); j++) {
                    stack.push(word.charAt(j) + "");
                }
                while(!stack.isEmpty()) {
                    bw.write(stack.pop());  // bw.write(String.valueOf(stack.pop()));
                }
                bw.write(" ");
            }
            bw.write("\n");  // bw.newLine();
        }
        br.close();
        bw.close();
    }
}
