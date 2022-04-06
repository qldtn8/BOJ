package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링 {

    static int N;
    static int[] popultaion;
    static char[] district;
    static int districtA, districtB;
    static boolean[][] adjMatrix;

    static int diffMin;

    public static void subSet(int nth, int totalA, int totalB) {
        if(nth == N) {
            if(bfs() && diffMin > Math.abs(totalA-totalB))
                diffMin = Math.abs(totalA-totalB);
            return;
        }

        // 1번 선거구에 포함.
        district[nth+1] = 'A'; districtA++;
        subSet(nth+1, totalA + popultaion[nth+1], totalB);
        districtA--;

        // 2번 선거구에 포함.
        district[nth+1] = 'B'; districtB++;
        subSet(nth + 1, totalA, totalB + popultaion[nth + 1]);
        districtB--;
    }

    public static boolean bfs() {
        if(districtA == 0 || districtB == 0) return false;

        // A 구역이 전부 연결되어있는 지 확인
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        int n = 0;
        for(int i = 1; 1 <= N; i++) {
            if (district[i] == 'A') {
                n = i;
                break;
            }
        }
        queue.offer(n);
        visited[n] = true;

        int count = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            for(int i = 1; i <= N; i++) {
                if(!visited[i] && adjMatrix[temp][i] && district[i] == 'A') {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        if(count != districtA) return false;

        // B 구역이 전부 연결되어있는 지 확인
        visited = new boolean[N+1];

        n = 0;
        for(int i = 1; 1 <= N; i++) {
            if (district[i] == 'B') {
                n = i;
                break;
            }
        }

        queue.offer(n);
        visited[n] = true;

        count = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            for(int i = 1; i <= N; i++) {
                if(!visited[i] && adjMatrix[temp][i] && district[i] == 'B') {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        if(count != districtB) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        popultaion = new int[N+1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            popultaion[i] = Integer.parseInt(token.nextToken());

        adjMatrix = new boolean[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            token.nextToken();
            while(token.hasMoreTokens()) {
                int k = Integer.parseInt(token.nextToken());
                adjMatrix[i][k] = true;
            }
        }

        diffMin = Integer.MAX_VALUE;
        district = new char[N+1];
        subSet(0, 0, 0);
        System.out.println(diffMin == Integer.MAX_VALUE ? -1 : diffMin);

    }
}

