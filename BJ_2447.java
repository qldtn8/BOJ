package BJ;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 별 찍기 - 10
 */
public class BJ_2447 {

    public static void star(String[][] arr, int x, int y, int N) {
        if(N == 3) {
            for(int i = x; i < x+3; i++) {
                for(int j = y; j < y+3; j++) {
                    if(!(i % 3 == 1 && j % 3 == 1)) {
                        arr[i][j] = "*";
                    }
                }
            }
        } else {
            for(int i = x; i < x+N; i += N/3) {
                for(int j = y; j < y+N; j+= N/3) {
                    if(!(i == x+N/3 && j == y+N/3)) {
                        star(arr, i, j, N/3);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = scanner.nextInt();
        String [][] array = new String[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                array[i][j] = " ";
            }
        }
        star(array, 0, 0, N);

        for(String [] line : array) {
            for(String str : line) {
                bw.write(str);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
