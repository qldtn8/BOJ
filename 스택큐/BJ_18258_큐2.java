package BJ.스택큐;

import java.io.*;
import java.util.*;

public class BJ_18258_큐2 {

    static List<String> queue = new ArrayList<>();
    static int head = 0;
    static int tail = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            String line = br.readLine();
            String[] split = line.split(" ");
            switch (split[0]) {
                case "front" :
                    bw.write(head == tail ? "-1" : queue.get(head));
                    break;
                case "back" :
                    bw.write(head == tail ? "-1" : queue.get(tail-1));
                    break;
                case "size" :
                    bw.write(""+(tail-head));
                    break;
                case "pop" :
                    bw.write(head == tail ? "-1" : queue.get(head++));
                    break;
                case "empty" :
                    bw.write(head == tail ? "1" : "0");
                    break;
                case "push" :
                    queue.add(split[1]);
                    tail++;
                    continue;
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
