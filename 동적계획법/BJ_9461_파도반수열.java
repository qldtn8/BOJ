package BJ.동적계획법;

import java.io.*;
import java.util.ArrayList;

public class BJ_9461_파도반수열 {

    static ArrayList<Long> dp;

    public static Long findPn(int N) {
        if(N < dp.size()) return dp.get(N);

        for(int i = dp.size(); i <= N; i++) {
            dp.add(dp.get(i-2) + dp.get(i-3));
        }
        return dp.get(N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new ArrayList<>();
        dp.add(0L);  // 0번째
        dp.add(1L);  // 1번째
        dp.add(1L);  // 2번째

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(findPn(N)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
