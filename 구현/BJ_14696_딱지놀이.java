package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14696_딱지놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[4];
        int[] b = new int[4];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(token.nextToken());
            for(int j = 0; j < count; j++) {
                a[token.nextToken().charAt(0)-'1']++;
            }
            token = new StringTokenizer(br.readLine());
            count = Integer.parseInt(token.nextToken());
            for(int j = 0; j < count; j++) {
                b[token.nextToken().charAt(0)-'1']++;
            }

            if(a[3] != b[3]) {
                output.append(a[3] > b[3] ? "A" : "B");
            } else if(a[2] != b[2]) {
                output.append(a[2] > b[2] ? "A" : "B");
            } else if(a[1] != b[1]) {
                output.append(a[1] > b[1] ? "A" : "B");
            } else if(a[0] != b[0]) {
                output.append(a[0] > b[0] ? "A" : "B");
            } else {
                output.append("D");
            }
            output.append("\n");
            Arrays.fill(a, 0);
            Arrays.fill(b, 0);
        }
        System.out.println(output.substring(0, output.length()-1));
    }
}
