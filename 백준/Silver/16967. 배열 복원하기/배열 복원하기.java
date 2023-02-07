import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(token.nextToken());
        int W = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());
        int Y = Integer.parseInt(token.nextToken());

        int[][] B = new int[H+X][W+Y];
        for(int r = 0; r < B.length; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < B[0].length; c++)
                B[r][c] = Integer.parseInt(token.nextToken());
        }

//        int[][] A = new int[H][W];
//        for(int r = 0; r < X; r++)
//            for(int c = 0; c < W; c++)
//                A[r][c] = B[r][c];
//
//        for(int r = H+X - 1; r > X; r--) {
//            for(int c = Y; c < W+Y; c++)
//                A[r - X][c-Y] = B[r][c];
//        }
//
//        for(int r = 0; r < H; r++) {
//            for(int c = 0; c < Y; c++)
//                A[r][c] = B[r][c];
//        }
//
//        for(int r = X; r < H; r++) {
//            for(int c = Y; c < W; c++) {
//                A[r][c] = B[r][c] - A[r-X][c-Y];
//            }
//        }
//
//        for (int[] rows : A) {
//            for (int col : rows) {
//                bw.write(col + " ");
//            }
//            bw.newLine();
//        }

        int[][] temp = new int[H][W];
        for(int r = 0; r < H; r++) {
            for(int c = 0; c < W; c++) {
                if(r < X) {
                    temp[r][c] = B[r][c];
                    continue;
                }

                if(c < Y) {
                    temp[r][c] = B[r][c];
                } else {
                    temp[r][c] = B[r][c] - temp[r-X][c-Y];
                }
            }
        }

        for (int[] rows : temp) {
            for (int col : rows) {
                bw.write(col + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }

}