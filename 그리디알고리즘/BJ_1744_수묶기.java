package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BJ_1744_수묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int result = 0;
        int i = 0;
        for(; i < N; i++) {
            if(arr[i] <= 0) break;
            if(i % 2 == 1) {
                if(arr[i] == 1) {
                    result += arr[i-1] + arr[i];
                } else
                    result += arr[i-1] * arr[i];
            }
        }
        if(i % 2 == 1 && (i == arr.length || arr[i] <= 0)) {
            result += arr[i-1];
        }

        Arrays.sort(arr);
        for(i = 0; i < N; i++) {
            if(arr[i] > 0) break;
            if(i % 2 == 1) {
                result += arr[i-1] * arr[i];
            }
        }
        if(i % 2 == 1 && (i == arr.length || arr[i] > 0)) {
            result += arr[i-1];
        }

        System.out.println(result);

    }
}

/*
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int result = 0;
        int i = 0;
        for(; i < N; i++) {
            if(arr[i] <= 0) break;
            if(i % 2 == 1) {
                result += arr[i-1] * arr[i];
            }
        }
        if(i % 2 == 1 && (i == arr.length || arr[i] <= 0)) {
            result += arr[i-1];
        }

        Arrays.sort(arr);
        for(i = 0; i < N; i++) {
            if(arr[i] > 0) break;
            if(i % 2 == 1) {
                result += arr[i-1] * arr[i];
            }
        }
        if(i % 2 == 1 && (i == arr.length || arr[i] > 0)) {
            result += arr[i-1];
        }

        System.out.println(result);

    }
}
 */

/*
public class BJ_1744_수묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int result = 0;
        int i = 0;
        for(; i < N; i++) {
            if(arr[i] <= 0) break;
            if(i % 2 == 1) {
                result += arr[i-1] * arr[i];
            }
        }
        if(i % 2 == 1 && (i == arr.length || arr[i] <= 0)) {
            result += arr[i-1];
        }

        int length = arr.length - i - (i < N && arr[i] == 0 ? 1 : 0);
        if(length == 0) {
            System.out.println(result);
            return;
        }

        for(int j = 0; j < length/2; j++) {
            result += arr[N-1-2*j] * arr[N-2-2*j];
        }
        if(arr[i] != 0) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
 */
