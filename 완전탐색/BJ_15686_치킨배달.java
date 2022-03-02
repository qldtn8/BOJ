package BJ.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15686_치킨배달 {

    static int N;
    static int M;
    static int[][] arr;
    static ArrayList<int[]> house;
    static ArrayList<int[]> chicken;
    static int total_min;

    public static void combination(int nth, int start, int flag) {
        if(nth == M) {
            int total = 0;
            for(int i = 0; i < house.size(); i++) {
                int min = Integer.MAX_VALUE;
                int[] h = house.get(i);
                for(int j = 0; j < chicken.size(); j++) {
                    if((flag & 1 << j) != 0) {
                        int[] c = chicken.get(j);
                        if(min > Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1])) {
                            min = Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]);
                        }
                    }
                }
                total += min;
            }
            if(total < total_min) {
                total_min = total;
            }
            return;
        }
        for(int i = start; i < chicken.size(); i++) {
            if((flag & 1 << i) == 0) {
                combination(nth + 1, i+1, flag | 1 << i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if(arr[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        total_min = Integer.MAX_VALUE;
        combination(0, 0, 0);
        System.out.println(total_min);
    }
}
