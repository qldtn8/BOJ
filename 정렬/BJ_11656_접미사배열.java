package BJ.정렬;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_11656_접미사배열 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = scanner.next();

        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i = 0; i < word.length(); i++) {
            pq.offer(word.substring(i, word.length()));
        }

        while(!pq.isEmpty()) {
            bw.write(pq.poll()+"\n");
        }
        bw.flush();
        bw.close();
        scanner.close();
    }
}
