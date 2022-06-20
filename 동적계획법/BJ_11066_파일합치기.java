package BJ.동적계획법;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11066_파일합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());

            StringTokenizer token = new StringTokenizer(br.readLine());
            int[][] fileSize = new int[K][K];
            int[][] dp = new int[K][K];
            for(int i = 0; i < K; i++)
                fileSize[i][i] = Integer.parseInt(token.nextToken());

            for(int d = 1; d < K; d++) {

                for(int r = 0; r + d < K; r++) {
                    int c = r + d;

                    int min = Integer.MAX_VALUE;
                    int minSize = Integer.MAX_VALUE;
                    for(int l = r; l < c; l++) {
                        int cal = dp[r][l] + dp[l+1][c] + fileSize[r][l] + fileSize[l+1][c];
                        if(min > cal) {
                            min = cal;
                            minSize = fileSize[r][l] + fileSize[l+1][c];
                        }
                    }
                    fileSize[r][c] = minSize;
                    dp[r][c] = min;
                }
            }
            bw.write(dp[0][K-1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
import java.io.*;
import java.util.StringTokenizer;

public class BJ_11066_파일합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());    // 소설을 구성하는 장의 수
            int[][] dp = new int[K][K];

            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 0; i < K; i++)
                dp[i][i] = Integer.parseInt(token.nextToken());

            for(int diff = 1; diff < K; diff++) {
                System.out.println(diff+"----------------------------");
                for(int idx = 0; idx+diff < K; idx++) {
                    System.out.println("("+idx+","+(idx+diff)+")");
                    dp[idx][idx+diff] = Integer.MAX_VALUE;
                    for(int i = idx; i < idx+diff; i++) {
                        System.out.print(i+"\t");
                        int temp = 0;
                        temp += dp[idx][i] + dp[i+1][idx+diff];
                        if(idx != i) temp += dp[idx][i];
                        if(i+1 != idx+diff) temp += dp[i+1][idx+diff];

                        if(temp < dp[idx][idx+diff]) dp[idx][idx+diff] = temp;
                    }
                    System.out.println("=>"+dp[idx][idx+diff]);
                }
            }
            bw.write(dp[0][K-1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
 */
