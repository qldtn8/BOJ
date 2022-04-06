package BJ.LIS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14003_가장긴증가하는부분수열5 {

    static int N;
    static int[] LIS;

    public static int binarySearch(int left, int right, int x) {
        int mid;
        while(left < right) {
            mid = (left + right) / 2;
            if(LIS[mid] < x) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        // 이분탐색 이용
        LIS = new int[N+1];
        LIS[0] = -1000000001;
        int length = 0;
        ArrayList<Integer> result = new ArrayList<>();

        int[] LISIndex = new int[N+1];
        for(int i = 1; i <= N; i++) {
            if(LIS[length] < A[i-1]) {
                LIS[++length] = A[i - 1];
                LISIndex[i] = length;
            }
            else {
                int index = binarySearch(1, length, A[i-1]);
                LIS[index] = A[i-1];
                LISIndex[i] = index;
            }
        }
        for(int i = N; i > 0 && length > 0; i--) {
            if(length == LISIndex[i]) {
                result.add(A[i-1]);
                length--;
            }
        }
        bw.write(result.size()+"\n");
        for(int i = result.size()-1; i >= 0; i--) {
            bw.write(result.get(i) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
