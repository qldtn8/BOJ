package BJ.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.exit;

public class BJ_2504_괄호의값 {

    public static void error() {
        System.out.println("0");
        exit(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();

        Stack<Character> stackForBra = new Stack<>();
        Stack<Integer> stackForNum = new Stack<>();

        for (char c : brackets.toCharArray()) {
            if(c == '(' || c == '[') stackForBra.push(c);
            else if(c == ')') {
                int sum = 0;
                while(true) {
                    if(stackForBra.isEmpty()) error();
                    Character pop = stackForBra.pop();
                    if(pop == 'N') sum += stackForNum.pop();
                    else if(pop == '(') break;
                    else error();
                }
                stackForBra.push('N');
                stackForNum.push(sum == 0 ? 2 : 2 * sum);
            } else {
                int sum = 0;
                while(true) {
                    if(stackForBra.isEmpty()) error();
                    Character pop = stackForBra.pop();
                    if(pop == 'N') sum += stackForNum.pop();
                    else if(pop == '[') break;
                    else error();
                }
                stackForBra.push('N');
                stackForNum.push(sum == 0 ? 3 : 3 * sum);
            }
        }

        int result = 0;
        while(!stackForBra.isEmpty()) {
            Character pop = stackForBra.pop();
            if(pop == 'N') result += stackForNum.pop();
            else error();
        }
        System.out.println(result);
    }
}
