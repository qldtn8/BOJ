package BJ;

import java.io.*;

/**
 * 수 정렬하기2 - 병합정렬 이용
 */
public class BJ_2751 {

    public static void conquer(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int index1 = start;
        int index2 = mid+1;
        int index = 0;

        while(index1 <= mid && index2 <= end) {
            if(arr[index1] <= arr[index2]) {
                temp[index++] = arr[index1++];
            } else {
                temp[index++] = arr[index2++];
            }
        }

        while(index1 <= mid) {
            temp[index++] = arr[index1++];
        }
        while(index2 <= end) {
            temp[index++] = arr[index2++];
        }
        for(int i = start; i <= end; i++) {
            arr[i] = temp[i-start];
        }
    }

    public static void divide(int[] arr, int start, int end) {
        if(start < end) {
            divide(arr, start, (start+end)/2);
            divide(arr, (start+end)/2 + 1, end);
            conquer(arr, start, (start+end)/2, end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        divide(arr, 0, N-1);

        for(int num : arr) {
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }
}
