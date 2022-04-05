package BJ.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_18353_병사배치하기 {

    static int N;
    static int[] arr;
    static int[] LIS;

    public static int binarySearch(int left, int right, int x) {
        int mid;

        while(left < right) {
            mid = (left+right) / 2;
            if(LIS[mid] < x) right = mid;
            else if(LIS[mid] > x)
                left = mid + 1;
            else
                return left;
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        LIS = new int[N+1];
        int len = 0;
        for(int i = 1; i <= N; i++) {
            int idx = binarySearch(1, 1+len, arr[i-1]);
            if(LIS[idx] == 0) len++;
            LIS[idx] = arr[i-1];
        }
        System.out.println(Arrays.toString(LIS));
        System.out.println(N-len);
    }
}
