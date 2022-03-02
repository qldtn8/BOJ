package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 요세푸스 문제
 */
public class BJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        LinkedList<Integer> circle = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            circle.add(i+1);
        }

        StringBuilder output = new StringBuilder("<");
        int count = 0;
        while(!circle.isEmpty()) {
            count += K-1;
            count %= circle.size();
            output.append(circle.remove(count)).append(", ");
        }
        System.out.println(output.substring(0, output.length()-2) + ">");
    }
}
