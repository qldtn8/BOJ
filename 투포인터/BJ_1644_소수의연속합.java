package BJ.투포인터;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1644_소수의연속합 {

    static boolean[] notPrime = new boolean[2001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int count = 0;
        ArrayList<Integer> dp = new ArrayList<>();
        int num = 1;
        while(++num <= N && num <= 2000) {
            if(!isPrime(num)) continue;

            System.out.println(num + "\t" + dp);
            int size = dp.size();
            for(int i = 0; i < size; i++) {
                if(dp.get(i)+num == N) count++;
                dp.add(dp.get(i)+num);
            }
            if(num == N) count++;
            dp.add(num);
        }
        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        int temp = 1;
        while(num * ++temp < 2001) {
            notPrime[num*temp] = true;
        }
        if(!notPrime[num]) return true;
        return false;
    }


}
