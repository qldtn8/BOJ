package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> card = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            card.add(i);
        }

        for(int i = 0; i < 2*N-3; i++) {
            if(i % 2 != 0) {
                card.add(card.removeFirst());
            } else {
                card.remove(0);
            }
        }
        System.out.println(card.get(0));
    }
}
