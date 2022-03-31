package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {

    static int N, M;    // 세로의 길이와 가로의 길이
    static int[][] arr; // 사각형 모양 판
    static int remain;  // 남은 치즈조각의 개수
    static boolean[][] visit;   //방문처리를 위한 배열

    // 4방탐색
    static int[][] deltas = {{-1, 0},{1, 0},{0, 1},{0, -1}};

    // 특정 r,c가 arr 내부에 접근할 수 있는 지
    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    // 치즈를 녹이기 위한 dfs
    public static void dfs(int r, int c) {
        visit[r][c] = true;
        for(int d = 0; d < deltas.length; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if(isIn(nr, nc) && arr[nr][nc] == 1) {  // (r, c)의 공기 주변에 치즈가 있을 경우
                // 치즈조각을 녹이고 해당 자리를 방문처리
                // 방문처리를 안하게 되면 원래 공기가 있는 곳으로 생각하여 dfs를 진행
                remain--;
                arr[nr][nc] = 0;
                visit[nr][nc] = true;
            }
        }

        for(int d = 0; d < deltas.length; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            // 방문하지 않은 곳 중 공기이면 dfs탐색!
            if(isIn(nr, nc) && !visit[nr][nc] && arr[nr][nc] == 0) {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];

        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(token.nextToken());
                if(arr[r][c] == 1) {
                    remain++;
                }
            }
        }
// --------------------------입력 끝---------------------------------

        int count = 0;  // 걸린 시간
        int answer = 0; // 모두 녹기 한 시간 전에 남아있는 치즈조각
        while(remain > 0) {
            visit = new boolean[N][M];  // 새로운 탐색을 위해 초기화
            count++;
            int before = remain;
            dfs(0, 0);
            if(remain == 0) {   // 모두 녹았으면 한 시간 전에 남아있는 치즈조각을 answer에 저장
                answer = before;
            }
        }
        System.out.println(count+"\n"+answer);
    }
}
