package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3040_백설공주와일곱난쟁이 {

    static int[] dwarf;
    static boolean[] isSelected;

    public static void combination(int nth, int start, int total) {
        if(nth == 7) {
            if(total == 100) {
                for(int i = 0; i < 9; i++) {
                    if(isSelected[i]) {
                        System.out.println(dwarf[i]);
                    }
                }
            }
            return;
        }

        for(int i = start; i < 9; i++) {
            isSelected[i] = true;
            combination(nth+1, i+1, total+dwarf[i]);

            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new int[9];
        isSelected = new boolean[9];
        for(int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        combination(0, 0, 0);
    }
}
