package BJ.트리그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_12851_숨바꼭질2 {

    public static final int MAX = 200001;

    public static boolean isIn(int n) {
        return 0 <= n && n < MAX;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 수빈이의 위치
        int K = scanner.nextInt();  // 동생의 위치

        int[] count = new int[MAX];   // 가장 빠른 시간으로 찾는 방법 수
        int[] minTime = new int[MAX];   // 가장 빠른 시간

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        count[N] = 1;


        int time = 0;
        boolean findSister = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            time++;
            while(size-- > 0) {
                int temp = queue.poll();
                if(temp == K) findSister = true;

                if(isIn(temp-1)) {
                    if(count[temp-1] == 0) {
                        minTime[temp-1] = time;
                        count[temp-1] = count[temp];
                        queue.offer(temp-1);
                    } else if(minTime[temp-1] == time) {
                        count[temp-1] += count[temp];
                    }
                }

                if(isIn(temp+1)) {
                    if(count[temp+1] == 0) {
                        minTime[temp+1] = time;
                        count[temp+1] = count[temp];
                        queue.offer(temp+1);
                    } else if(minTime[temp+1] == time) {
                        count[temp+1] += count[temp];
                    }
                }

                if(isIn(temp*2)) {
                    if(count[temp*2] == 0) {
                        minTime[temp*2] = time;
                        count[temp*2] = count[temp];
                        queue.offer(temp*2);
                    } else if(minTime[temp*2] == time) {
                        count[temp*2] += count[temp];
                    }
                }
            }
            if(findSister) break;
        }
        System.out.println((time-1)+"\n"+count[K]);
    }
}
