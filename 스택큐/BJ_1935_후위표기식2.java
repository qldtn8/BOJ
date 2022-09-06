package BJ.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BJ_1935_후위표기식2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();

        List<Integer> operand = new LinkedList<>();
        while(N-- > 0) {
            operand.add(Integer.parseInt(br.readLine()));
        }

        Stack<Double> stack = new Stack<>();
        for(char c : postfix.toCharArray()) {
            if('A' <= c && c <= 'Z') stack.push((double) operand.get(c-'A'));
            else {
                Double o1 = stack.pop();
                Double o2 = stack.pop();
                if(c == '*') stack.push(o1 * o2);
                else if(c == '/') stack.push(o2 / o1);
                else if(c == '+') stack.push(o1 + o2);
                else stack.push(o2 - o1);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
