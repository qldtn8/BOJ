package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕 {

    static int R, C, T;
    static int[][] rooms;
    static int[][] dust;
    static int[] aircleaner;

    static int[][] deltas = {{-1, 0},{1, 0},{0, 1},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        T = Integer.parseInt(token.nextToken());

        rooms = new int[R][C];
        aircleaner = new int[2];
        for(int r = 0; r < R; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < C; c++) {
                rooms[r][c] = Integer.parseInt(token.nextToken());
                if(rooms[r][c] == -1 && rooms[r-1][c] == -1) {
                    aircleaner[1] = r;
                } else if(rooms[r][c] == -1) {
                    aircleaner[0] = r;
                }
            }
        }

        for(int t = 0; t < T; t++) {
            // 미세먼지 확산
            dust = new int[R][C];
            for(int r = 0; r < R; r++) {
                for(int c = 0; c < C; c++) {
                    if(rooms[r][c] != 0 && rooms[r][c] != -1) {
                        int temp = rooms[r][c] / 5;
                        for(int d = 0; d < deltas.length; d++) {
                            int nr = r + deltas[d][0];
                            int nc = c + deltas[d][1];
                            if(isIn(nr, nc) && rooms[nr][nc] != -1) {
                                dust[nr][nc] += temp;
                                dust[r][c] -= temp;
                            }
                        }
                    }
                }
            }
            for(int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (dust[r][c] != 0) {
                        rooms[r][c] += dust[r][c];
                    }
                }
            }
            // 공기청정기 가동
            for(int r = aircleaner[0]-1; r > 0; r--) {
                rooms[r][0] = rooms[r-1][0];
            }
            for(int r = aircleaner[1] + 1; r < R-1; r++) {
                rooms[r][0] = rooms[r+1][0];
            }
            for(int c = 0; c < C-1; c++) {
                rooms[0][c] = rooms[0][c+1];
                rooms[R-1][c] = rooms[R-1][c+1];
            }
            for(int r = 0; r < aircleaner[0]; r++) {
                rooms[r][C-1] = rooms[r+1][C-1];
            }
            for(int r = R-1; r > aircleaner[1]; r--) {
                rooms[r][C-1] = rooms[r-1][C-1];
            }
            for(int c = C-1; c > 1; c--) {
                rooms[aircleaner[0]][c] = rooms[aircleaner[0]][c-1];
                rooms[aircleaner[1]][c] = rooms[aircleaner[1]][c-1];
            }
            rooms[aircleaner[0]][1] = 0;
            rooms[aircleaner[1]][1] = 0;
        }
        System.out.println(calculate());
    }
    public static int calculate() {
        int total = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(rooms[r][c] != -1 && rooms[r][c] != 0) {
                    total += rooms[r][c];
                }
            }
        }
        return total;
    }
}
