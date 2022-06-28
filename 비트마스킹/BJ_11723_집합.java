package BJ.비트마스킹;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11723_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = 0;

        int M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            String command = token.nextToken();

            switch (command) {
                case "add" :
                    int x = Integer.parseInt(token.nextToken());
                    if((S & 1 << x) == 0) {
                        S = S | 1 << x;
                    }
                    break;
                case "remove" :
                    x = Integer.parseInt(token.nextToken());
                    if((S & 1 << x) != 0) {
                        S =  S ^ 1 << x;
                    }
                    break;
                case "check" :
                    x = Integer.parseInt(token.nextToken());
                    bw.write((S & 1 << x) == 0 ? "0\n" : "1\n");
                    break;
                case "toggle" :
                    x = Integer.parseInt(token.nextToken());
                    if((S & 1 << x) != 0) S = S ^ 1 << x;
                    else S = S | 1 << x;
                    break;
                case "all" :
                    S = 0;
                    for(int i = 1; i <= 20; i++) {
                        S = S | 1 << i;
                    }
                    break;
                case "empty" :
                    S = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
