package BJ;

import java.io.*;
import java.util.Stack;

/**
 * 스택 수열
 */
public class BJ_1874_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int index = 1;
        Stack<Integer> stack = new Stack<>();
        int sequence;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sequence = Integer.parseInt(br.readLine());


            int j;
            for(j = index; j <= sequence; j++) {
                stack.push(j);
                result.append("+").append("\n");
            }
            index = j;

            if(stack.peek() > sequence) {
                result = new StringBuilder("NO");
                break;
            } else if(stack.peek() == sequence) {
                stack.pop();
                if(i == N-1) {
                    result.append("-");
                } else {
                    result.append("-").append("\n");
                }
            }
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }
}