package BJ.구현;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BJ_17413_단어뒤집기2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        String line = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < line.length(); i++) {
            char temp = line.charAt(i);
            if(!stack.isEmpty() && (temp == '<' || temp == ' ')) {
                while(!stack.isEmpty()) {
                    output.append(stack.pop());
                }
                if(temp == ' ') output.append(" ");
            }
            if(temp == '<') {
                while(line.charAt(i) != '>') {
                    output.append(line.charAt(i++));
                }
                output.append(line.charAt(i));
            } else if(temp != ' '){
                stack.push(temp);
            }
        }
        while(!stack.isEmpty()) {
            output.append(stack.pop());
        }
        System.out.println(output);
    }
}
