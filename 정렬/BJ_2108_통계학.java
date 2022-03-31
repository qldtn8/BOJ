package BJ.정렬;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_2108_통계학 {

    static class Number implements Comparable<Number> {
        int count, num;
        public Number(int count, int num) {
            this.count = count;
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            if(this.count == o.count)
                return this.num - o.num;
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) {
                max = arr[i];
            }
            if(min > arr[i]) {
                min = arr[i];
            }
            sum += arr[i];
        }
        Arrays.sort(arr);
        bw.write(Math.round((double)sum / N)+"\n");
        bw.write(arr[N/2]+"\n");

        PriorityQueue<Number> pq = new PriorityQueue<>();
        int count = 0;
        int pre = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            if(pre == arr[i]) {
                count++;
            } else {
                if(i != 0) pq.offer(new Number(count, pre));
                count = 1;
                pre = arr[i];
            }
            if(i == N-1) {
                pq.offer(new Number(count, pre));
            }
        }
        Number temp = pq.poll();
        if(pq.size() > 0 && pq.peek().count == temp.count)
            temp = pq.poll();
        bw.write(temp.num+"\n");
        bw.write((max - min)+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
