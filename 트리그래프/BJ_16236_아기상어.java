package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16236_아기상어 {

    static class Position implements Comparable<Position> {
        int x, y, time;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Position o) {
            if(this.time != o.time) {
                return Integer.compare(this.time, o.time);
            }
            if(this.x != o.x) {
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y);
        }
    }

    static int N;
    static int[][] arr; // 공간
    static int row, col;    // 아기상어의 위치
    static int babyShark = 2;   // 아기상어의 크기
    static int numOfEatting = 0;
    static int[] fish;  // 물고기의 수

    static int[][] deltas = {{-1, 0},{0, -1},{1, 0},{0, 1}};

    public static int howManyOfEatting() {
        int sum = 0;
        int end = babyShark > 6 ? 7 : babyShark;
        for(int i = 1; i < end; i++) {
            sum += fish[i];
        }
        return sum;
    }

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    // 현재 아기상어의 위치부터 먹을 수 있는 물고기의 위치(r, c)까지 최단 시간.
    public static int bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<Position> queue = new LinkedList<>();
        PriorityQueue<Position> pq = new PriorityQueue<>();

        queue.offer(new Position(row, col));
        visited[row][col] = true;

        int time = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            time++;
            while(size-- > 0) {
                Position p = queue.poll();

                if(arr[p.x][p.y] != 0 && arr[p.x][p.y] < babyShark) {
                    p.time = time;
                    pq.offer(p);
                }

                for(int d = 0; d < deltas.length; d++) {
                    int nr = p.x + deltas[d][0];
                    int nc = p.y + deltas[d][1];
                    if(isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] <= babyShark) {
                        visited[nr][nc] = true;
                        queue.offer(new Position(nr, nc));
                    }
                }
            }
        }
        if(pq.isEmpty())
            return -1;

        Position p = pq.poll();
        row = p.x;
        col = p.y;
        fish[arr[row][col]]--;
        arr[row][col] = 0;
        numOfEatting++;
        return p.time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        fish = new int[7];

        StringTokenizer token;
        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(token.nextToken());
                if(arr[r][c] == 9) {
                    row = r; col = c;
                    arr[r][c] = 0;
                } else if(arr[r][c] != 0) {
                    fish[arr[r][c]]++;
                }
            }
        }
        if(fish[1] == 0) {
            System.out.println(0);
            return;
        }

        int sec = 0;    // 먹을 수 있는 물고기가 있을 때 다 먹는데 걸리는 시간.
        int fishCount = howManyOfEatting();   // 먹을 수 있는 물고기의 개수
        while(fishCount > 0) {
            int temp = bfs();
            if(temp < 0) {
                break;
            }
            sec += temp;
            //System.out.println("time : " + sec);
            //System.out.println("\t\t위치 " + row + " : " + col);
            if(numOfEatting == babyShark) {
                babyShark++;
                numOfEatting = 0;
            }
            //System.out.println("\t\tbabyShark " + babyShark + "  numOfEatting " + numOfEatting);
            fishCount = howManyOfEatting();
            //System.out.println("\t\t" + fishCount + " " + Arrays.toString(fish));
        }
        System.out.println(sec);
    }
}

