package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정 {

    static int N;   // 회의실 수
    static int[][] meetingroom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        meetingroom = new int[N][2];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            meetingroom[i][0] = Integer.parseInt(token.nextToken());
            meetingroom[i][1] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(meetingroom, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] - o2[1] == 0) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int total = 0;
        int lastMeeting = -1;
        for(int i = 0; i < N; i++) {
            if(lastMeeting <= meetingroom[i][0] && lastMeeting <= meetingroom[i][1]) {
                lastMeeting = meetingroom[i][1];
                total++;
            }
        }
        System.out.println(total);
    }
}
