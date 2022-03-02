package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이 {

    static int[] dwarfs;
    static boolean[] isSelected;
    static final int TOTAL_HEIGHT = 100;
    static int total;

    public static void combination(int cnt, int current) {
        if(cnt == 7) {
            if(total == TOTAL_HEIGHT) {
                for(int i = 0; i < dwarfs.length; i++) {
                    if(isSelected[i]) {
                        System.out.println(dwarfs[i]);
                    }
                }
            }
            return;
        }
        for(int i = current; i < dwarfs.length; i++) {
            total += dwarfs[i];
            isSelected[i] = true;
            combination(cnt+1,i+1);
            if(total == TOTAL_HEIGHT) break;

            total -= dwarfs[i];
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarfs = new int[9];
        isSelected = new boolean[9];

        for(int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }
        total = 0;
        Arrays.sort(dwarfs);
        combination(0, 0);
    }
}
