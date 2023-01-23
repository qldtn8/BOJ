import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());

        int[] visited = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            visited[i] = Integer.parseInt(token.nextToken());


        int sum = 0;
        for(int i = 0; i < X; i++)
            sum += visited[i];

        int maxVisited = sum;
        int left = 1, right = X;
        while(right < N) {
            sum -= visited[left++-1];
            sum += visited[right++];

            if(maxVisited < sum)
                maxVisited = sum;
        }

        if(maxVisited == 0) {
            System.out.println("SAD");
            return;
        }

        int count = 0;

        sum = 0;
        for(int i = 0; i < X; i++)
            sum += visited[i];

        if(sum == maxVisited)
            count++;

        left = 1;
        right = X;
        while(right < N) {
            sum -= visited[left++-1];
            sum += visited[right++];

            if(sum == maxVisited)
                count++;
        }

        System.out.println(maxVisited);
        System.out.println(count);

    }
}