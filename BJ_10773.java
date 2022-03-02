package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number != 0) {
                stack.add(number);
            } else {
                stack.remove(stack.size()-1);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.remove(stack.size()-1);
        }
        System.out.println(sum);
    }
}
