package BJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11725 {

    static boolean[][] node;
    static int[] parentNode;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder("");
        N = Integer.parseInt(br.readLine());
        node = new boolean[N][];
        for(int i = 0; i < N; i++) {
            node[i] = new boolean[i];
        }
        parentNode = new int[N];
        for(int i = 1; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            if(a < b) {
                node[b-1][a-1] = true;
            } else {
                node[a-1][b-1] = true;
            }
        }

        for(int c = 0; c < N-1; c++) {
            for(int r = c+1; r < N; r++) {
                if(node[r][c] && parentNode[r] == 0) {
                    parentNode[r] = c+1;
                } else if(node[r][c] && parentNode[r] != 0) {
                    parentNode[c] = r+1;
                }
            }
        }
        for(int i = 1; i < N; i++) {
            output.append(parentNode[i]+"\n");
        }
        System.out.println(output.substring(0, output.length()-1));
    }
}
