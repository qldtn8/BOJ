import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++)
            deque.add(i);

        int count = 0;

        boolean[] removed = new boolean[N];

        token = new StringTokenizer(br.readLine());
        while(token.hasMoreTokens()) {
            int m = Integer.parseInt(token.nextToken());

            if(removed[m-1])
                continue;

            if(deque.peek() == m) {
                deque.pop();
                removed[m-1] = true;
                continue;
            }

            int right= 0;   // 오른쪽방향으로 m까지의 거리
            int index = deque.peek() - 1;
            while(true) {
                index = (index + 1) % N;
                if(removed[index]) continue;
                right++;
                if(index + 1 == m) break;
            }

            int left = 0;   // 왼쪽방향으로 m까지의 거리
            index = deque.peek() - 1;
            while(true) {
                index = (index + N - 1) % N;
                if(removed[index]) continue;
                left++;
                if(index + 1 == m) break;
            }

            removed[m-1] = true;
            // 오른쪽 탐색이 더 빠른경우
            if(right <= left) {
                count += right;
                while(true) {
                    Integer temp = deque.pop();
                    if(temp == m) break;
                    else deque.add(temp);
                }
            } else {
                count += left;
                while(true) {
                    Integer temp = deque.removeLast();
                    if(temp == m) break;
                    else deque.addFirst(temp);
                }
            }
        }
        System.out.println(count);
    }
}