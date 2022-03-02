package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 체스판 다시 칠하기
 */
public class BJ_1018 {

    public static int findCount(char[][] arr, int i, int j) {
        int sum1 = 0;
        for(int r = i; r < i+8; r++) {
            for(int c = j; c < j+8; c++) {
                if ((r + c) % 2 == 0 && arr[r][c] != arr[i][j]) {
                    sum1++;
                }
                if ((r + c) % 2 != 0 && arr[r][c] == arr[i][j]) {
                    sum1++;
                }
            }
        }

        int sum2 = 0;
        for(int r = i; r < i+8; r++) {
            for(int c = j; c < j+8; c++) {
                if((r+c) % 2 == 0 && arr[r][c] == arr[i][j]) {
                    sum2++;
                }
                if((r+c) % 2 != 0 && arr[r][c] != arr[i][j]) {
                    sum2++;
                }
            }
        }
        return (sum1 > sum2) ? sum2 : sum1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                int count = findCount(arr, i, j);
                if(min > count) {
                    min = count;
                }
            }
        }
        System.out.println(min);
    }
}
