package BJ.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11053_가장긴증가하는부분수열 {

    static int N;
    static int[] LIS;

    public static int binarySearch(int left, int right, int x) {
        int mid;
        while(left < right) {
            mid = (left+right) / 2;
            if(LIS[mid] < x) left = mid + 1;
            else if(LIS[mid] > x) right = mid;
            else return mid;
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        LIS = new int[N+1];
        int length = 0;
        for(int i = 1; i <= N; i++) {
            int index = binarySearch(1, 1+length, arr[i-1]);
            if(LIS[index] == 0) length++;
            LIS[index] = arr[i-1];
        }
        System.out.println(length);
    }
}
