package BJ.트리그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697_숨바꼭질 {

    static int N, K;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        // 흠...범위...
        visit = new boolean[(N < K) ? K*2 : N*2];
        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N); // 수빈이가 있는 위치 queue에 추가
        int depth = 0;  // 깊이
        outer : while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while(size-- > 0) {
                int temp = queue.poll();
                if(temp == K) { // 동생이 있는 위치이면 bfs 중단
                    break outer;
                }
                // 수빈이의 위치 범위는 0 <= N <= 100000
                // temp-1을 방문한적 없다면 queue에 추가
                if(0 <= temp-1 && temp-1 < visit.length && !visit[temp-1]) {
                    queue.offer(temp-1);
                    visit[temp-1] = true;
                }
                // temp+1을 방문한적 없다면 queue에 추가
                if(0 <= temp+1 && temp+1 < visit.length && !visit[temp+1]) {
                    queue.offer(temp + 1);
                    visit[temp+1] = true;
                }
                // temp*2를 방문한적 없다면 queue에 추가
                if(0 <= temp*2 && temp*2 < visit.length && !visit[temp*2]) {
                    queue.offer(temp * 2);
                    visit[temp*2] = true;
                }
            }
        }
        System.out.println(depth-1);
    }
}
