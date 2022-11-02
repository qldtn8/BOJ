package BJ.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_1269_대칭차집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        Set<Integer> A = new HashSet<>();
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(token.nextToken()));
        }
        Set<Integer> B = new HashSet<>();
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            B.add(Integer.parseInt(token.nextToken()));
        }

        int dup = 0;
        for (Integer integer : B) {
            if(A.contains(integer)) dup++;
        }

        System.out.println((N+M-dup-dup));
    }
}
