package BJ.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노 {

    static int N, M;
    static int[][] paper;
    static boolean[][] visit;
    static int max;

    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
    }

    // DFS를 이용해서 ㅗ모양을 제외한 나머지 테트로미노 확인.
    public static void tetromino1(int nth, int row, int col, int sum) {
        if(nth == 4) {  // 폴리오미노가 4개가 되면 테트로미노가 완성
            max = Math.max(sum, max);   // 테트로미노의 합을 MAX와 비교
            return;
        }
        visit[row][col] = true; // 방문처리
        for(int d = 0 ; d < deltas.length; d++) {   // 4방 탐색
            int nr = row + deltas[d][0];
            int nc = col + deltas[d][1];
            if(isIn(nr,nc) && !visit[nr][nc]) {
                tetromino1(nth+1, nr, nc, sum + paper[nr][nc]);
            }
        }
        visit[row][col] = false;
    }

    // ㅗ 모양 테트로미노의 합 구하기
    public static void tetromino2(int row, int col) {
        // 연속된 3개의 폴리오미노가 우선 존재해야 하므로 ㅡ 모양 있는 지 확인
        if(isIn(row, col+2)) {
            int sum = paper[row][col] + paper[row][col+1] + paper[row][col+2];
            if(isIn(row-1, col+1)) {    // ㅗ 모양
                max = Math.max(max, sum + paper[row-1][col+1]);
            }
            if(isIn(row+1, col+1)) {    // ㅜ 모양
                max = Math.max(max, sum + paper[row+1][col+1]);
            }
        }

        // 이 부분은 현재 row, col에서 왼쪽으로 생기는 ㅗ, ㅜ 모양인데.....
        // 이게 row-2, col에서 오른쪽으로 생기는 ㅗ, ㅜ 모양과 중복된다... 그래서 필요없는 코드...
//        if(isIn(row, col-2)) {
//            int sum = paper[row][col] + paper[row][col-1] + paper[row][col-2];
//            if(isIn(row-1, col-1)) {    // ㅗ 모양
//                max = Math.max(max, sum + paper[row-1][col-1]);
//            }
//            if(isIn(row+1, col-1)) {    // ㅜ 모양
//                max = Math.max(max, sum + paper[row+1][col-1]);
//            }
//        }

        // ㅣ 모양 있는 지 확인
        if(isIn(row+2, col)) {
            int sum = paper[row][col] + paper[row+1][col] + paper[row+2][col];
            if(isIn(row+1, col-1)) {    // ㅓ 모양
                max = Math.max(max, sum + paper[row+1][col-1]);
            }
            if(isIn(row+1, col+1)) {    // ㅏ 모양
                max = Math.max(max, sum + paper[row+1][col+1]);
            }
        }

        // 이 부분은 현재 row, col에서 위쪽으로 생기는 ㅓ, ㅏ 모양인데.....
        // 이게 row, col-2에서 아래쪽으로 생기는 ㅓ, ㅏ 모양과 중복된다...
//        if(isIn(row-2, col)) {
//            int sum = paper[row][col] + paper[row-1][col] + paper[row-2][col];
//            if(isIn(row-1, col-1)) {
//                max = Math.max(max, sum + paper[row-1][col-1]);
//            }
//            if(isIn(row-1, col+1)) {
//                max = Math.max(max, sum + paper[row-1][col+1]);
//            }
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        paper = new int[N][M];
        visit = new boolean[N][M];  // dfs 방문처리를 위한 boolean 배열

        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                paper[r][c] = Integer.parseInt(token.nextToken());
            }
        }
        // 입력끝---------------------------------------------------


        // 완탐 시작!!
        max = Integer.MIN_VALUE;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                tetromino1(1, r, c, paper[r][c]);
                tetromino2(r, c);
            }
        }
        System.out.println(max);
    }
}
