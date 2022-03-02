package BJ.구현;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ_11866_요세푸스문제0 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        LinkedList<Integer> p = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            p.add(i);
        }

        output.append("<");
        int index = 0;
        while(p.size() != 0) {
            index += K-1;
            if(index >= p.size()) {
                index %= p.size();
            }
            output.append(p.remove(index)+", ");
        }
        System.out.println(output.substring(0, output.length()-2) + ">");
    }
}
