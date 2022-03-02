package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20304_비밀번호제작 {

    static int N;	// 패스워드의 최댓값
    static int M;	// 해커가 사용한 패스워드 개수
    static String[] hacker;	// 해커가 사용한 패스워드를 저장해 놓은 배열

    /**
     * 파라미터로 입력받은 number를 이진법 String으로 반환한다.
     * 10은 1010 이 아닌, 뒤집힌 0101로 반환.
     * 8은 100이 아닌, 001로 반환.
     * @param number
     * @return
     */
    public static String intToString(int number) {
        if(number == 0) {
            return "0";
        }

        StringBuilder output = new StringBuilder();
        while(true) {
            if(number / 2 != 0) {
                if(number % 2 == 0) output.append("0");
                else output.append("1");

                number = number/2;
            } else {
                output.append("1");
                break;
            }
        }
        return output.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        N = Integer.parseInt(br.readLine());	// N 입력받기
        M = Integer.parseInt(br.readLine());	// M 입력받기
        hacker = new String[M];		// 해커가 입력한 패스워드를 저장할 배열

        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int m = 0; m < M; m++) {
            hacker[m] = intToString(Integer.parseInt(token.nextToken()));
        }

        int max = Integer.MIN_VALUE;		// 가장 높은 보안성
        for(int n = 0; n <= N; n++) {
            int security = Integer.MAX_VALUE;	// 새로운 패스워드 n과 해커가 시도했던 모든 패스워드와의 보안척도 중 최솟값.
            String pw = intToString(n);	// n을 이진법으로 변환.
            for(int m = 0; m < M; m++) {	// 해커가 시도했던 횟수만큼 반복
                String tryPW = hacker[m];
                int idx1 = 0;	// 이진법 n을 첫번째 자리부터 탐색하기 위한 인덱스
                int idx2 = 0;	// 해커가 시도한 비밀번호를 첫번째 자리부터 탐색하기 위한 인덱스
                int temp = 0;	// n과 hacker[m]의 보안척도

                while(idx1 < pw.length() && idx2 < tryPW.length()) {	// 둘 중 자리수가 작은게 탐색이 끝날 때까지 반복
                    if(pw.charAt(idx1++) != tryPW.charAt(idx2++)) {	// idx1, idx2 번째 자리가 다르면
                        temp++;										// 보안척도 1증가
                    }
                }
                while(idx1 < pw.length()) {	// n의 이진법 탐색이 다 끝나지 않았으면 while문 실행
                    if(pw.charAt(idx1++) == '1') {	// 이때 tryPW의 자리수는 모두 0 이므로 pw의 자리수가 1이면 보안척도 증가
                        temp++;
                    }
                }
                while(idx2 < tryPW.length()) {	// 해커가 시도한 비밀번호의 이진법 탐색이 다 끝나지 않았으면 while문 실행
                    if(tryPW.charAt(idx2++) == '1') {	// 이때 pw의 자리수는 모두 0이므로 tryPW의 자리수가 1이면 보안척도 증가
                        temp++;
                    }
                }

                if(temp < security) {	// n과 해커가 시도한 m번째 패스워드와의 보안척도가 기존보다 낮으면 갱신
                    security = temp;
                }
                if(temp <= max) {
                    break;
                }
            }
            if(max < security) {
                max = security;
            }
        }
        System.out.println(max);
    }
}
