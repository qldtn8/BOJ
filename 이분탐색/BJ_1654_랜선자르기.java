package BJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1654_랜선자르기 {

    static int N, K;
    static ArrayList<Integer> lans;
    static long maxLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        K = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        lans = new ArrayList<>();
        long avg = 0;
        for(int i = 0; i < K; i++) {
            lans.add(Integer.parseInt(br.readLine()));
            avg += lans.get(i);
        }

        binarySearch(avg / N + 1);
        System.out.println(maxLength);

    }

    public static void binarySearch(long MAX) {
        long left = 1;
        long right = MAX;

        long mid;
        while(left < right) {
            mid = (left + right) / 2;

            int count = counting(mid);
            if(count < N) right = mid;
            else {
                left = mid+1;
                System.out.println("mid : " + mid +"\t count = " + count);
                maxLength = Math.max(maxLength, mid);
            }
        }
    }

    public static int counting(long length) {
        int count = 0;
        for(int lan : lans) {
            count += lan / length;
        }
        return count;
    }
}
