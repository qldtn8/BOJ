package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010_다리놓기 {

    static int T;
    static int R;
    static int N;

//    public static void combination(int start, int count) {
//        if(count == R -1) {
//            total += N -start;
//            return;
//        }
//        for(int i = start; i < N; i++) {
//            combination(i+1, count+1);
//        }
//
//    }

    public static int combination2(int n, int r) {
        if(r == 0 || r == n) {
            return 1;
        }
        return combination2(n-1, r-1) + combination2(n-1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder output = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine());
            R = Integer.parseInt(token.nextToken());
            N = Integer.parseInt(token.nextToken());

            if(R > N /2) R = N - R;
            output.append(combination2(N, R)+"\n");
        }
        System.out.println(output.toString());
    }
}
