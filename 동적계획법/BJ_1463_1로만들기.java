package BJ.동적계획법;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1463_1로만들기 {

    static int X;

    public static void bfs() {
        boolean[] visited = new boolean[X];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);

        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int x = queue.poll();

                if(x == 1) {
                    System.out.println(depth);
                    return;
                }

                if(x % 3 == 0) {
                    visited[x/3] = true;
                    queue.offer(x / 3);
                }
                if(x % 2 == 0) {
                    visited[x/2] = true;
                    queue.offer(x / 2);
                }
                if(x - 1 > 0) {
                    visited[x-1] = true;
                    queue.offer(x-1);
                }
            }
            depth++;
        }

    }

    public static void dp() {
        int[] D = new int[X+1];
        D[1] = 0;

        for(int i = 2; i <= X; i++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            if(i % 3 == 0) a = D[i/3]+1;
            if(i % 2 == 0) b = D[i/2]+1;
            int c = D[i-1]+1;
            D[i] = Math.min(c, Math.min(a, b));
        }
        System.out.println(D[X]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        X = scanner.nextInt();
        //bfs();
        dp();
    }
}
