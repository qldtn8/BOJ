package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1592_영식이와친구들 {

    static int N, M, L;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());
        count = new int[N];

        int ball = 0;   // 볼을 가지고 있는 사람의 인덱스
        count[ball]++;
        int toss = 0;
        while(count[ball] < M) {
            if(count[ball] % 2 == 0) {
                ball = (ball - L) < 0 ? N+(ball-L) : ball-L;
            } else {
                ball = (ball + L) % N;
            }
            count[ball]++;
            toss++;
        }
        System.out.println(toss);
    }
}
