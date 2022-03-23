package BJ.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10989_수정렬하기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        for(int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder output = new StringBuilder();
        for(int i = 1; i < 10001; i++) {
            if(count[i] != 0) {
                for(int j = 0; j < count[i]; j++) {
                    output.append(i+"\n");
                }
            }
        }
        System.out.println(output);
    }
}
