import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        List<String> title = new ArrayList<>();
        List<Integer> power = new ArrayList<>();
        for(int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            title.add(token.nextToken());
            power.add(Integer.parseInt(token.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            int character = Integer.parseInt(br.readLine());
            int head = 0, tail = N - 1;
            while(head <= tail) {
                int mid = (head + tail) / 2;
                if(power.get(mid) < character)
                    head = mid + 1;
                else
                    tail = mid - 1;
            }
            sb.append(title.get(head) + "\n");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

}