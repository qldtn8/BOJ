package BJ.분할정복;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11582_치킨TOPN {

    static int N, k;
    static int[] arr;
    static BufferedWriter bw;

    public static void sort(int start, int end) {
        int mid = (start + end) / 2;

        int s1 = start;
        int s2 = mid;
        int[] newArr = new int[end-start];
        for(int i = 0; i < newArr.length; i++) {
            if(s1 >= mid) newArr[i] = arr[s2++];
            else if(s2 >= end) newArr[i] = arr[s1++];
            else if(arr[s1] < arr[s2]) newArr[i] = arr[s1++];
            else newArr[i] = arr[s2++];
        }

        for(int i = 0; i < newArr.length; i++) {
            arr[start++] = newArr[i];
        }
    }

    public static void mergeSort(int nth) throws IOException {
        int count = N / nth;
        for(int i = 0; i < N; i+= count) {
            sort(i, i+count);
        }

        if(nth == k) {
            for(int i = 0; i < N; i++) {
                bw.write(arr[i] + " ");
            }
            return;
        } else {
            mergeSort(nth/2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        k = Integer.parseInt(br.readLine());

        mergeSort(N/2);
        bw.flush();
        bw.close();
        br.close();
    }
}
