package BJ.트리그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3197_백조의호수 {

    static class Position {
        int r, c;
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C;
    static char[][] map;
    static ArrayList<Position> swans;
    static Queue<Position> bufferQueue;
    static Queue<Position> water;

    static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new char[R][C];
        water = new LinkedList<>();
        swans = new ArrayList<>();
        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'L') swans.add(new Position(r, c));
                if(map[r][c] == '.' || map[r][c] == 'L') water.offer(new Position(r, c));
            }
        }

        int day = 0;
        bufferQueue = new LinkedList<>();
        bufferQueue.offer(swans.get(0));
        targetSwan = swans.get(1);
        visited = new boolean[R][C];
        while(!water.isEmpty()) {
            if(canMeet()) {
                break;
            }
            day++;
            melting();
        }
        System.out.println(day);
    }

    public static void melting() {
        int size = water.size();
        while(size-- > 0) {
            Position p = water.poll();

            for(int[] d : deltas) {
                int nr = p.r + d[0];
                int nc = p.c + d[1];
                if(isIn(nr, nc) && map[nr][nc] == 'X') {
                    water.offer(new Position(nr, nc));
                    map[nr][nc] = '.';
                }
            }
        }
    }

    static boolean[][] visited;
    static Position targetSwan;

    public static boolean canMeet() {
        Queue<Position> queue = new LinkedList<>();

        int bufferSize = bufferQueue.size();
        while(bufferSize-- > 0) {
            Position bufferPos = bufferQueue.poll();
            if (visited[bufferPos.r][bufferPos.c]) continue;

            visited[bufferPos.r][bufferPos.c] = true;
            queue.offer(bufferPos);

            while (!queue.isEmpty()) {
                Position p = queue.poll();

                if (p.r == targetSwan.r && p.c == targetSwan.c) {
                    return true;
                }

                for (int[] d : deltas) {
                    int nr = p.r + d[0];
                    int nc = p.c + d[1];
                    if (isIn(nr, nc) && !visited[nr][nc]) {
                        if (map[nr][nc] == '.' || map[nr][nc] == 'L') {
                            visited[nr][nc] = true;
                            queue.offer(new Position(nr, nc));
                        } else bufferQueue.offer(new Position(nr, nc));
                    }
                }
            }
        }
        return false;
    }
}
