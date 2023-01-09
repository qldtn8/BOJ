import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int sum = 0;
        while(token.hasMoreTokens()) {
            int num = Integer.parseInt(token.nextToken());
            sum += Math.pow(num, 2);
        }
        System.out.println(sum % 10);
    }
}