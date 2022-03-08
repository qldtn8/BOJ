package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1062_가르침 {

    static int N, K;
    static String[] words;
    static int total;

    public static void countWord(int flag) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            boolean readable = true;
            for(int j = 0; j < words[i].length(); j++) {
                if((flag & 1 << (int)(words[i].charAt(j)-'a')) == 0) {
                    readable = false;
                    break;
                }
            }
            if(readable) count++;
            if(total < count) total = count;
        }
    }

    public static void combination(int nth, int start, int flag) {
        if(nth == K) {
            countWord(flag);
            return;
        }

        for(int i = start; i <= (int)('z'-'a'); i++) {
            if( (flag & 1 << i ) == 0 ) {
                combination(nth+1, i+1, flag | 1 << i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        words = new String[N];
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 남극언어의 모든 단어가 "anta"로 시작해 "tica"로 끝나므로 여기서 필요한 최소한의 알파벳 개수는 5개.
        // a n t i c
        if(K < 5) {
            System.out.println(0);
            return;
        }
        if(K == 26) {
            System.out.println(N);
            return;
        }

        int flag = 1 << (int)('a'-'a');
        flag = flag | 1 << (int)('n'-'a');
        flag = flag | 1 << (int)('t'-'a');
        flag = flag | 1 << (int)('i'-'a');
        flag = flag | 1 << (int)('c'-'a');


        total = 0;
        combination(5, 0, flag);
        System.out.println(total);
    }
}
