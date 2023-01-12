import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        while(N-- > 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            String command = token.nextToken();
            switch (command) {
                case "push" :
                    int x = Integer.parseInt(token.nextToken());
                    queue.add(x);
                    continue;
                case "pop" :
                    bw.write("" + (queue.isEmpty() ? "-1" : queue.pop()));
                    break;
                case "size" :
                    bw.write("" + queue.size());
                    break;
                case "empty" :
                    bw.write("" + (queue.isEmpty() ? 1 : 0));
                    break;
                case "front" :
                    bw.write("" + (queue.isEmpty() ? "-1" : queue.peek()));
                    break;
                case "back" :
                    bw.write("" + (queue.isEmpty() ? "-1" : queue.peekLast()));
                    break;
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}