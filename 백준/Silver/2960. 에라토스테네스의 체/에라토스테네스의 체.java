import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        boolean[] removed = new boolean[N+1];

        int num = 2;

        while(true) {
            for(int i = num; i <= N; i += num) {
                if(!removed[i]) {
                    K--;
                    removed[i] = true;

                    if(K == 0) {
                        System.out.println(i);
                        return;
                    }
                }
            }

            while(true) {
                num++;
                if(!removed[num]) break;
            }
        }
    }
}