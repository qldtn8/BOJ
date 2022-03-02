package BJ.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2503_숫자야구 {

    static class Answer {
        String answer;
        int s;
        int b;
        public Answer(String answer, int s, int b) {
            this.answer = answer;
            this.s = s;
            this.b = b;
        }
    }

    static int N;
    static Answer[] answers;
    static int total;

    public static void baseballgame(int[] guess) {
        String temp = ""+guess[0]+guess[1]+guess[2];
        for(int i = 0; i < N; i++) {
            int s = 0;
            int b = 0;
            for(int j = 0; j < 3; j++) {
                if(temp.indexOf(answers[i].answer.charAt(j)) == j) {
                    s++;
                } else if(temp.indexOf(answers[i].answer.charAt(j)) != -1) {
                    b++;
                }
            }
            if(s != answers[i].s || b != answers[i].b) {
                return;
            }
        }
        total++;
    }

    // 숫자 3개 생성
    public static void permutation(int nth, int[] choosed, int flag) {
        if(nth == 3) {
            baseballgame(choosed);
            return;
        }
        for(int i = 1; i < 10; i++) {
            if((flag & 1 << i) == 0) {
                choosed[nth] = i;
                permutation(nth+1, choosed, flag | 1 << i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        N = Integer.parseInt(br.readLine());
        answers = new Answer[N];

        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            answers[i] = new Answer(token.nextToken(), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }
        total = 0;
        permutation(0, new int[3], 0);
        System.out.println(total);
    }
}
