package BJ;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 큐 2
 */
public class BJ_18258 {

    static LinkedList<Integer> queue = new LinkedList<>();

    public static void push(int x) {
        queue.add(x);
    }

    public static int pop() {
        if(queue.isEmpty()) {
            return -1;
        }
        return queue.removeFirst();
    }

    public static int size() {
        return queue.size();
    }

    public static int empty() {
        return queue.isEmpty() ? 1 : 0;
    }

    public static int front() {
        if(queue.isEmpty()) {
            return -1;
        }
        return queue.getFirst();
    }

    public static int back() {
        if(queue.isEmpty()) {
            return -1;
        }
        return queue.getLast();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder("");

        int command = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for(int i = 0; i < command; i++) {
            token = new StringTokenizer(br.readLine());
            switch (token.nextToken()) {
                case "push" : push(Integer.parseInt(token.nextToken()));
                    break;
                case "pop" :
                    str.append(pop()).append("\n");
                    break;
                case "size" :
                    str.append(size()).append("\n");
                    break;
                case "empty" :
                    str.append(empty()).append("\n");
                    break;
                case "front" :
                    str.append(front()).append("\n");
                    break;
                case "back" :
                    str.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(str.substring(0, str.length()-1));
        br.close();
    }
}
