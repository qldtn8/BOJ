package BJ.동적계획법;

import java.io.*;
import java.util.ArrayList;

public class BJ_9095_123더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> DP = new ArrayList<>();
        DP.add(1);
        DP.add(1);  // 정수 1을 1,2,3의 합으로 나타내는 방법의 가지 수
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            if(n < DP.size()) {
                bw.write(DP.get(n)+"\n");
            } else {
                for(int i = DP.size(); i <= n; i++) {
                    int total = 0;
                    if(i - 1 >= 0) total += DP.get(i-1);
                    if(i - 2 >= 0) total += DP.get(i-2);
                    if(i - 3 >= 0) total += DP.get(i-3);
                    DP.add(total);
                }
                bw.write(DP.get(n)+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
