package BJ.정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2470_두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(token.nextToken()));
        }
        list.sort((o1, o2) -> Math.abs(o1) - Math.abs(o2));
        int min = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;
        for(int i = 0; i < N-1; i++) {
            int sum = list.get(i) + list.get(i+1);
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                idx1 = i;
                idx2 = i+1;
            }
        }
        if(list.get(idx1) < list.get(idx2))
            System.out.println(list.get(idx1) + " " + list.get(idx2));
        else
            System.out.println(list.get(idx2) + " " + list.get(idx1));
    }
}
