package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기 {

    static int L, C;
    static char[] alpha;
    static StringBuilder output;

    public static void combination(int toChoose, int start, int flag, int vowel) {
        if(toChoose == 0 && vowel >= 1 && (L-vowel) >= 2) {
            for(int i = 0; i < C; i++) {
                if((flag & 1 << i) != 0) {
                    output.append(alpha[i]);
                }
            }
            output.append("\n");
            return;
        }
        for(int i = start; i < C; i++) {
            if((flag & 1 << i) == 0) {
                int v = vowel;
                if("aeiou".indexOf(alpha[i]) != -1) {
                    v++;
                }
                combination(toChoose-1,i+1, flag | 1 << i, v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine());

        L = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        alpha = new char[C];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            alpha[i] = token.nextToken().charAt(0);
        }
        Arrays.sort(alpha);
        combination(L, 0, 0, 0);
        System.out.println(output.toString());
    }
}
