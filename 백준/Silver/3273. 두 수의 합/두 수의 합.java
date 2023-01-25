import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int count = 0;

        int l = 0;
        int r = N-1;

        while(l < r) {
            int mid = arr[l] + arr[r];
            
            if(mid == x) {
                count++;
                l++;
                r--;
            } else if(mid > x) {
                r--;
            } else {
                l++;
            }
        }
        System.out.println(count);

    }
}