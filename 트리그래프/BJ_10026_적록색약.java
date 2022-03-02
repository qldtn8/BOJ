package BJ.트리그래프0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_10026_적록색약 {

    static int N;
    static char[][] matrix;
    static boolean[][] visited;

    static int[][] deltas = {{-1, 0},{1, 0},{0, 1},{0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        // 정상인
        int section1 = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, true);
                    section1++;
                }
            }
        }
        // 적록색약인
        visited = new boolean[N][N];
        int section2 = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, false);
                    section2++;
                }
            }
        }
        System.out.println(section1 + " " + section2);

    }

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void bfs(int r, int c, boolean isNormal) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int d = 0; d < deltas.length; d++) {
                int nr = temp[0] + deltas[d][0];
                int nc = temp[1] + deltas[d][1];
                if(isIn(nr,nc) && !visited[nr][nc]) {
                    if(isNormal && matrix[nr][nc] == matrix[temp[0]][temp[1]]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                    if(!isNormal) {
                        if(matrix[temp[0]][temp[1]] == 'B' && matrix[nr][nc] == 'B') {
                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr, nc});
                        }
                        if(matrix[temp[0]][temp[1]] != 'B' && matrix[nr][nc] != 'B') {
                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr, nc});
                        }
                    }

                }
            }
        }

    }
}
