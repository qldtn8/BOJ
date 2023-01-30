import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= 10000; i++) {
            dp[i] = dp[i-3] + i/2 + 1;
        }

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");
        }

        bw.flush();
        bw.close();
    }
}