package BJ.재귀;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 별 찍기 - 11
 */
public class BJ_2448_별찍기11 {

    static void star(char[][] arr, int x, int y, int N) {
        if(N == 3) {
            for(int i = 0; i < 3; i++) {
                for(int j = 2-i; j < 3+i; j++) {
                    if(!(i == 1 && j == 2)) {
                        arr[i+x][j+y] = '*';
                    }
                }
            }
        } else {
            for(int i = 0; i < N; i += N/2) {
                if(i == 0) {
                    star(arr, i+x, y+N/2, N/2);
                } else {
                    star(arr, i+x, y, N/2);
                    star(arr, i+x, y+N, N/2);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = scanner.nextInt();
        char[][] arr = new char[N][2*N-1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2*N-1; j++) {
                arr[i][j] = ' ';
            }
        }
        star(arr, 0, 0, N);

        for(char[] line : arr) {
            for(char temp : line) {
                bf.write(temp);
            }
            bf.write("\n");
        }
        bf.flush();
        bf.close();
    }
}
