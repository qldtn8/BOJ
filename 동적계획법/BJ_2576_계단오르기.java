package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2576_계단오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for(int i = 1; i < N+1; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int[][] stairs = new int[N+1][2];
        stairs[1][0] = stairs[1][1] = arr[1];
        for(int i = 2; i <= N; i++) {
            // 현재 계단을 올 때 두 계단을 밟고 왔을 때
            stairs[i][0] = Math.max(stairs[i-2][0], stairs[i-2][1]) + arr[i];
            // 현재 계단을 올 때 한 계단을 밟고 왔을 때, 전 계단을 한 칸 밟고 올라간 상태여야 한다.
            stairs[i][1] = stairs[i-1][0] + arr[i];
        }
        System.out.println(Math.max(stairs[N][0], stairs[N][1]));
    }
}
