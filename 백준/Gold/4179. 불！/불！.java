import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int R, C;
    public static char[][] map;
    public static Queue<int[]> fires;
    public static int[] start;
    public static int[][] deltas = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        map = new char[R][C];
        fires = new LinkedList<>();

        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'J')
                    start = new int[]{r, c};
                else if(map[r][c] == 'F')
                    fires.add(new int[]{r, c});
            }
        }

        int day = bfs();
        System.out.println(day != -1 ? day : "IMPOSSIBLE" );

    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        boolean[][] visited = new boolean[R][C];
        visited[start[0]][start[1]] = true;

        int day = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            day++;
            while(size-- > 0) {
                int[] point = queue.poll();

                if(map[point[0]][point[1]] == 'F')
                    continue;

                if(point[0] == 0 || point[0] == R -1 || point[1] == 0 || point[1] == C - 1)
                    return day;

                for(int[] d : deltas) {
                    int nr = point[0] + d[0];
                    int nc = point[1] + d[1];

                    if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }

            size = fires.size();
            while(size-- > 0) {
                int[] point = fires.poll();

                for(int[] d : deltas) {
                    int nr = point[0] + d[0];
                    int nc = point[1] + d[1];

                    if(isIn(nr, nc) && map[nr][nc] != 'F' && map[nr][nc] != '#') {
                        map[nr][nc] = 'F';
                        fires.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}