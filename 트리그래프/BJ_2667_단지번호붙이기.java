package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2667_단지번호붙이기 {

    static int N;
    static boolean[][] map;
    static LinkedList<Integer> complex;

    static int[][] deltas = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        complex = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = (line.charAt(j) == '1') ? true : false;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j]) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(complex);
        output.append(complex.size()+"\n");
        for(int i = 0; i < complex.size(); i++) {
            output.append(complex.get(i)+"\n");
        }
        System.out.println(output.toString());
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        map[r][c] = false;
        int count = 0;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            count++;
            for(int d = 0; d < deltas.length; d++) {
                int nr = temp[0] + deltas[d][0];
                int nc = temp[1] + deltas[d][1];
                if(0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc]) {
                    map[nr][nc] = false;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        complex.add(count);
    }
}
