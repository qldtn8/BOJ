package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11403_경로찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] adjMatrix = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                if(token.nextToken().equals("1")) {
                    adjMatrix[i][j] = true;
                }
            }
        }


        StringBuilder output = new StringBuilder();
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                // r, c에 대하여 경로가 존재하는 지
                boolean path = false;

                Queue<Integer> queue = new LinkedList<>();
                boolean[] visited = new boolean[N];

                for(int i = 0; i < N; i++) {
                    if(adjMatrix[r][i]) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }

                while(!queue.isEmpty()) {
                    int temp = queue.poll();
                    if(temp == c) {
                        path = true;
                        break;
                    }
                    for(int i = 0; i < N; i++) {
                        if(!visited[i] && adjMatrix[temp][i]) {
                            visited[i] = true;
                            queue.offer(i);
                        }
                    }
                }
                output.append(path ? "1 " : "0 ");
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}
