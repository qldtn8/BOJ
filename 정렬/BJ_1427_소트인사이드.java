package BJ.정렬;

import java.util.Scanner;

public class BJ_1427_소트인사이드 {

    static int[] numbers;

    public static void mergeSort(int start, int end) {
        if(end - start == 1) return;
        // divide
        int mid = (start+end) / 2;
        mergeSort(start, mid);
        mergeSort(mid, end);
        // conquer & combine
        int[] newArr = new int[end-start];
        int i = start;
        int j = mid;
        for(int k = 0; k < newArr.length; k++) {
            if(i >= mid) newArr[k] = numbers[j++];
            else if(j >= end) newArr[k] = numbers[i++];
            else if(numbers[i] > numbers[j]) newArr[k] = numbers[i++];
            else newArr[k] = numbers[j++];
        }
        for(int k = start; k < end; k++) {
            numbers[k] = newArr[k-start];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        numbers = new int[10];
        int index = 0;
        while(line > 0) {
            numbers[index++] = line % 10;
            line /= 10;
        }
        mergeSort(0, index);

        StringBuilder output = new StringBuilder();
        for(int i = 0; i < index; i++) {
            output.append(numbers[i]);
        }
        System.out.println(output);
    }
}
