package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11000_강의실배정 {

    static int N;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())});
        }

        int classroom = 0;
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            classroom++;

        }
        System.out.println(classroom);
    }
}
