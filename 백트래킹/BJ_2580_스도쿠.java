package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_2580_스도쿠 {

    static final int N = 9;
    static int[][] arr;
    static LinkedList<int[]> list;
    static boolean success;


    public static void permutation(int nth) {
        if(nth == list.size()) {
            success = true;
            return;
        }
        int[] p = list.get(nth);
        outer : for(int i = 1; i <= N; i++) {
            arr[p[0]][p[1]] = i;
            // 검증
            for(int c = 0; c < N; c++) {
                if(c != p[1] && arr[p[0]][c] == i) {
                    continue outer;
                }
            }
            for(int r = 0; r < N; r++) {
                if(r != p[0] && arr[r][p[1]] == i) {
                    continue outer;
                }
            }
            for(int r = 3*(p[0]/3); r < 3*(p[0]/3)+3; r++) {
                for(int c = 3*(p[1]/3); c < 3*(p[1]/3)+3; c++) {
                    if(r != p[0] && c != p[1] && arr[r][c] == i) {
                        continue outer;
                    }
                }
            }
            permutation(nth+1);
            if(success) return;
        }
        arr[p[0]][p[1]] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[N][N];
        list = new LinkedList<>();

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 0) {
                    list.add(new int[]{i,j});
                }
            }
        }

        permutation(0);

        StringBuilder output = new StringBuilder();
        for(int[] a : arr) {
            for(int b : a) {
                output.append(b + " ");
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}
