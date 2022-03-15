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


    /*
    지금 자리에 i(1<= i < 10)의 값을 넣는게 유망한가...?
     */
    public static void permutation(int nth) {
        // 빈칸의 개수만큼 다돌았으면 스도쿠를 완성했으므로 종류.
        if(nth == list.size()) {
            success = true;
            return;
        }

        int[] p = list.get(nth);    // 빈칸 자리
        outer : for(int i = 1; i <= N; i++) {
            arr[p[0]][p[1]] = i;    // 빈칸에 일단 i를 넣어본다.

            //검증

            // 가로줄에서 똑같은 숫자가 나왔으면? -> 다음 i값 확인
            for(int c = 0; c < N; c++) {
                if(c != p[1] && arr[p[0]][c] == i) {
                    continue outer;
                }
            }

            // 세로줄에서 똑같은 숫자가 나왔으면? -> 다음 i값 확인
            for(int r = 0; r < N; r++) {
                if(r != p[0] && arr[r][p[1]] == i) {
                    continue outer;
                }
            }

            // 3x3영역에서 똑같은 숫자가 나왔으면? -> 다음 i값 확인
            for(int r = 3*(p[0]/3); r < 3*(p[0]/3)+3; r++) {
                for(int c = 3*(p[1]/3); c < 3*(p[1]/3)+3; c++) {
                    if(r != p[0] && c != p[1] && arr[r][c] == i) {
                        continue outer;
                    }
                }
            }

            // 위에 걸리지 않았다면 i는 유망할수도 있음!!
            // 다음 빈칸을 확인하자.
            permutation(nth+1);

            // 갔다왔는데 스도쿠 완성했다면?? 다음 i값 확인하지말고 바로 return!!
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
                if(arr[i][j] == 0) {    // 빈칸을 list에 저장.
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
