package BJ;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 스택
 */
public class BJ_10828 {

    private LinkedList<Integer> stack;

    public BJ_10828() {
        stack = new LinkedList<>();
    }

    public void push(Integer x) {
        stack.add(x);
    }

    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.removeLast();
    }

    public int size() {
        return stack.size();
    }

    public int empty() {
        return stack.isEmpty() ? 1 : 0;
    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.getLast();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        BJ_10828 bj = new BJ_10828();
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            String command = token.nextToken();
            switch (command) {
                case "push" : bj.push(Integer.parseInt(token.nextToken()));
                    break;
                case "pop" : bw.write(String.valueOf(bj.pop())); bw.newLine();
                    break;
                case "size" : bw.write(String.valueOf(bj.size())); bw.newLine();
                    break;
                case "empty" : bw.write(String.valueOf(bj.empty())); bw.newLine();
                    break;
                case "top" : bw.write(String.valueOf(bj.top())); bw.newLine();
                    break;
            }
        }
        br.close();
        bw.close();
    }
}
