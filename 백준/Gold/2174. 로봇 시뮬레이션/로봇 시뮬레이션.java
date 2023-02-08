import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static class Robot {
        int r, c, dir;

        public Robot(int r, int c, String dir) {
            this.r = r;
            this.c = c;
            if(dir.equals("N")) this.dir = 0;
            else if(dir.equals("E")) this.dir = 1;
            else if(dir.equals("S")) this.dir = 2;
            else this.dir = 3;
        }
    }

    static int C, R;
    static int[][] map;
    static Robot[] robots;

    static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};

    public static boolean isIn(int r, int c) {
        return 0 < r && r <= R && 0 < c && c <= C;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        map = new int[R+1][C +1];

        token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        robots = new Robot[N+1];

        for(int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            String dir = token.nextToken();
            map[r][c] = i;
            robots[i] = new Robot(r, c, dir);
        }

        while(M-- > 0) {
            token = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(token.nextToken());
            String  command = token.nextToken();
            int repeat = Integer.parseInt(token.nextToken());

            Robot robot = robots[idx];

            switch (command) {
                case "L" :
                    robot.dir = (4 + robot.dir - repeat % 4) % 4;
                    break;
                case "R" :
                    robot.dir = (robot.dir + repeat % 4) % 4;
                    break;
                case "F" :
                    int nr = robot.r;
                    int nc = robot.c;
                    for(int i = 0; i < repeat; i++) {
                        nr += deltas[robot.dir][0];
                        nc += deltas[robot.dir][1];

                        if(isIn(nr, nc)) {
                            if(map[nr][nc] != 0) {
                                System.out.println("Robot " + idx + " crashes into robot " + map[nr][nc]);
                                return;
                            }
                        } else {
                            System.out.println("Robot " + idx + " crashes into the wall");
                            return;
                        }
                    }
                    map[robot.r][robot.c] = 0;
                    map[nr][nc] = idx;
                    robot.r = nr;
                    robot.c = nc;
                    break;
            }
        }
        System.out.println("OK");
    }
}