package BJ.스택큐;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BJ_10866_덱 {

    static List<String> dequeue = new LinkedList<>();
    static Deque<String> deque = new LinkedList<>();
    static int head = 0;
    static int tail = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            String[] words = br.readLine().split(" ");
            switch (words[0]) {
                case "push_front" :
                    deque.addFirst(words[1]);
                    continue;
                case "push_back" :
                    deque.addLast(words[1]);
                    continue;
                case "pop_front" :
                    bw.write(deque.isEmpty() ? "-1" : deque.pollFirst());
                    break;
                case "pop_back" :
                    bw.write(deque.isEmpty() ? "-1" : deque.pollLast());
                    break;
                case "size" :
                    bw.write(deque.size()+"");
                    break;
                case "empty" :
                    bw.write(deque.isEmpty() ? "1" : "0");
                    break;
                case "front" :
                    bw.write(deque.isEmpty() ? "-1" : deque.peekFirst());
                    break;
                case "back" :
                    bw.write(deque.isEmpty() ? "-1" : deque.peekLast());
                    break;
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
