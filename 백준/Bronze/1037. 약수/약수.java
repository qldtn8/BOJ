import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] arr = new int[A];
        for(int i = 0; i < A; i++)
            arr[i] = Integer.parseInt(token.nextToken());

        Arrays.sort(arr);

        if(A == 1)
            System.out.println(arr[0] * arr[0]);
        else
            System.out.println(arr[0] * arr[A-1]);
    }
}