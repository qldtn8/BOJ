package BJ.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15961_회전초밥 {

    static int N, d, k, c;
    static int[] sushi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        d = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        sushi = new int[N];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d+1];
        int start = 0;
        int end = (k-1) % N;
        int typeOf = 0;
        for(int i = start; i <= end; i++) {
            if(count[sushi[i]]++ == 0) typeOf++;
        }

        int max = typeOf;
        while(start < N) {
            if(count[sushi[start++]]-- == 1)
                typeOf--;
            if(count[sushi[++end % N]]++ == 0)
                typeOf++;

            max = Math.max(max, (count[c] == 0 ? typeOf+1 : typeOf));
        }
        System.out.println(max);
    }
}
