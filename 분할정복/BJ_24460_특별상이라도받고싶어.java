package BJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_24460_특별상이라도받고싶어 {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int r = 0; r < N; r++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        for(int n = 1; n < N; n *= 2) {
            for(int r = 0; r < N; r+=2*n) {
                for(int c = 0; c < N; c+=2*n) {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.offer(arr[r][c]);
                    pq.offer(arr[r][c+n]);
                    pq.offer(arr[r+n][c]);
                    pq.offer(arr[r+n][c+n]);
                    pq.poll();
                    arr[r][c] = pq.poll();
                }
            }
        }
        System.out.println(arr[0][0]);
    }
}
