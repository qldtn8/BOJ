package BJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2374_같은수로만들기 {

    static ArrayList<Integer> list = new ArrayList<>();

    public static long divideConquer(int left, int right, int pre) {
        if(right <= left) return 0;
        if(right-left == 1) return pre - list.get(left);

        int max = left;
        for(int i = left+1; i < right; i++) {
            if(list.get(max) < list.get(i)) {
                max = i;
            }
        }
        return (pre-list.get(max)) + divideConquer(left, max, list.get(max)) + divideConquer(max+1, right, list.get(max));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = -1;
        int pre = -1000000001;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(pre == num) continue;

            list.add(num);
            if (i == 0) max = 0;
            else {
                if(list.get(max) < list.get(list.size()-1)) {
                    max = list.size()-1;
                }
            }
        }
        System.out.println(divideConquer(0, max, list.get(max))+divideConquer(max+1, list.size(), list.get(max)));
    }
}
