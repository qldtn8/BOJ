package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300_방배정 {

    static int N, K;
    static int[][] students;
    static int rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        students = new int[6][2];
        rooms = 0;

        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(token.nextToken());
            int grade = Integer.parseInt(token.nextToken())-1;

            if(students[grade][gender] == 0) {
                rooms++;
            }
            students[grade][gender]++;
            if(students[grade][gender] == K) {
                students[grade][gender] = 0;
            }
        }
        System.out.println(rooms);
    }
}
