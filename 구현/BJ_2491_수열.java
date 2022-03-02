package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491_수열 {

    static int N;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        int max = -1;
        int count = 0;
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(token.nextToken());
            count++;
            if(i == 0) continue;

            if(numbers[i] < numbers[i-1]) {
                if(max < --count) {
                    max = count;
                }
                count = 1;
            }
        }
        if(max < count) {
            max = count;
        }
        count = 0;
        for(int i = 0; i < N; i++) {
            count++;
            if(i == 0) continue;
            if(numbers[i] > numbers[i-1]) {
                if(max < --count) {
                    max = count;
                }
                count = 1;
            }
        }
        if(max < count) {
            max = count;
        }
        System.out.println(max);
    }
}
