package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 균형잡힌 세상
 */
public class BJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder("");

        String line;
        while(!(line = br.readLine()).equals(".")) {
            LinkedList<Character> stack = new LinkedList<>();
            boolean isBalacne = true;
            for(int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if(ch == '(' || ch == '[') {
                    stack.add(ch);
                } else if(ch == ')') {
                    if(!stack.isEmpty() && stack.getLast() == '(') {
                        stack.removeLast();
                    } else {
                        isBalacne = false;
                        break;
                    }
                } else if(ch == ']') {
                    if(!stack.isEmpty() && stack.getLast() == '[') {
                        stack.removeLast();
                    } else {
                        isBalacne = false;
                        break;
                    }
                }
            }
            if(stack.isEmpty() && isBalacne) {
                output.append("yes");
            } else {
                output.append("no");
            }
            output.append("\n");
        }
        System.out.println(output.substring(0, output.length()-1));
    }
}
