package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 탑
 */
public class BJ_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder("");

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringTokenizer token = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            int data = Integer.parseInt(token.nextToken());

            while(!stack.isEmpty()) {
                if(stack.peek()[1] < data) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if(stack.isEmpty()) {
                output.append("0 ");
            } else {
                output.append(stack.peek()[0] + " ");
            }
            stack.push(new int[]{i, data});
        }
        System.out.println(output.substring(0, output.length()-1));
    }
}
