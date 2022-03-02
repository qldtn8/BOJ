package BJ.그리디알고리즘;

import java.util.Scanner;

public class BJ_2875_대회or인턴 {

    static int N;   // 여학생의 수
    static int M;   // 남학생의 수
    static int K;   // 인턴에 참여해야할 인원

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();

        // 한명씩 줄여나갈 것
        for(int k = 0; k < K; k++) {
            // 현재 여학생이 남학생의 2배보다 크거나 같을 경우에는 여학생을 감소.
            if(N >= M * 2) {
                N--;
            } else {    // 그게 아닐 경우에는 남학생을 감소.
                M--;
            }
        }

        int total = 0;
        if(M >= N / 2) {
            total = N / 2;
        } else {
            total = M;
        }
        System.out.println(total);
    }
}
