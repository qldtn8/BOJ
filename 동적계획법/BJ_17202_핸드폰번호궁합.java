package BJ.동적계획법;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_17202_핸드폰번호궁합 {

    static String A, B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        A = scanner.next();
        B = scanner.next();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < 8; i++) {
            queue.offer(Integer.parseInt(String.valueOf(A.charAt(i))));
            queue.offer(Integer.parseInt(String.valueOf(B.charAt(i))));
        }

        while(queue.size() > 2) {
            int size = queue.size();
            while(size-- > 1) {
                int result = queue.poll() + queue.peek();
                queue.offer(result % 10);
            }
            queue.poll();
        }
        System.out.println(queue.poll()+""+queue.poll());
    }
}
