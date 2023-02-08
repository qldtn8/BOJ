import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int W = Integer.parseInt(token.nextToken());
        int L = Integer.parseInt(token.nextToken());

        int[] trucks = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            trucks[i] = Integer.parseInt(token.nextToken());


        int n = 0;  // 다리위에 올라가있는 트럭 개수
        int l = 0;  // 다리위에 올라가있는 트럭의 무게 합
        int idx = 0, time = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int w = 0; w < W; w++)
            queue.add(-1);

        while(idx < N) {
            time++;
            // 다리를 다 건너간 트럭 처리
            int prev = queue.poll();
            if(prev != -1) {
                n--;
                l -= trucks[prev];
            }

            // 다리에 올릴 트럭 처리
            if(n == N || l + trucks[idx] > L) {
                queue.add(-1);
                continue;
            }
            n++;
            l += trucks[idx];
            queue.add(idx++);

        }
        System.out.println(time + W);
    }
}