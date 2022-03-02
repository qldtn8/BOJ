package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1713_후보추천하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        LinkedList<Integer> frame = new LinkedList<>();

        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] recommend = new int[100];
        for(int i = 0; i < K; i++) {
            int temp = Integer.parseInt(token.nextToken())-1;
            recommend[temp]++;
            if(frame.contains(temp)) continue;
            if(frame.size() < N) {
                frame.add(temp);
            } else {
                int minIndex = 0;
                for(int j = 0; j < frame.size(); j++) {
                    if(recommend[frame.get(minIndex)] > recommend[frame.get(j)]) {
                        minIndex = j;
                    }
                }
                recommend[frame.remove(minIndex)] = 0;
                frame.add(temp);
            }
        }
        Collections.sort(frame);
        for(int i = 0; i < frame.size(); i++) {
            System.out.print((frame.get(i)+1) + " ");
        }
    }
}
