import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] budget = new int[N];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(token.nextToken());
            if(max < budget[i]) max = budget[i];
        }

        int left = 0, right = max;
        while(left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for (int b : budget) {
                if(b > mid) sum += mid;
                else sum += b;
            }

            if(sum == M) break;
            else if(sum > M) right = mid - 1;
            else left = mid + 1;
        }

        System.out.println((left + right) / 2);
    }
}