package BJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 스택 수열
 */
public class BJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int index = 1;
        Stack<Integer> stack = new Stack<>();
        int [] sequence = new int[N];
        for(int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        int sIndex = 0;
        String result = "";
        while(index <= N) {
            stack.push(index++);
            result += "+\n";

            if(!stack.isEmpty() && stack.peek() > sequence[sIndex]) {
                break;
            }

            while(true) {
                if(!stack.isEmpty() && stack.peek() == sequence[sIndex]) {
                    stack.pop();
                    sIndex++;
                    if(sIndex == N) {
                        result += "-";
                    } else {
                        result += "-\n";
                    }
                } else {
                    break;
                }
            }
        }
        if(sIndex == N && stack.isEmpty()) {
            bw.write(result);
        } else {
            bw.write("NO");
        }

        br.close();
        bw.close();
    }
}