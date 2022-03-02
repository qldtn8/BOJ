package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_2217_로프 {

    static int N;
    static Integer[] rope;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rope = new Integer[N];

        for(int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int maxWeight = 0;
        for(int i = 0; i < N; i++) {
            if(rope[i] * (i+1) > maxWeight) {
                maxWeight = rope[i] * (i+1);
            }
        }
        System.out.println(maxWeight);
    }
}
