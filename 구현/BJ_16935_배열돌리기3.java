package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16935_배열돌리기3 {

    static int N, M;    // NxM 배열
    static int R;   // Rotation 횟수
    static int[][] arr;
    static int[] command;

    public static void rotation1() {
        for(int r = 0; r < N/2; r++) {
            int[] temp = arr[r];
            arr[r] = arr[N-1-r];
            arr[N-1-r] = temp;
        }
    }

    public static void rotation2() {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M/2; c++) {
                int temp = arr[r][c];
                arr[r][c] = arr[r][M-1-c];
                arr[r][M-1-c] = temp;
            }
        }
    }

    public static void rotation3() {
        int[][] newArr = new int[M][N];
        for(int c = 0; c < M; c++) {
            for(int r = 0; r < N; r++) {
                newArr[c][N-1-r] = arr[r][c];
            }
        }
        arr = newArr;
        int temp = N;
        N = M;
        M = temp;
    }

    public static void rotation4() {
        int[][] newArr = new int[M][N];
        for(int c = 0; c < M; c++) {
            for(int r = 0; r < N; r++) {
                newArr[M-1-c][r] = arr[r][c];
            }
        }
        arr = newArr;
        int temp = N;
        N = M;
        M = temp;
    }


    public static void rotation5() {
        int[][] temp = new int[N/2][M/2];
        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < temp[0].length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        for(int r = N/2; r < N; r++) {
            for(int c = 0; c < M/2; c++) {
                arr[r-N/2][c] = arr[r][c];
            }
        }
        for(int r = N/2; r < N; r++) {
            for(int c = M/2; c < M; c++) {
                arr[r][c-M/2] = arr[r][c];
            }
        }
        for(int r = 0; r < N/2; r++) {
            for(int c = M/2; c < M; c++) {
                arr[r+N/2][c] = arr[r][c];
            }
        }
        for(int r = 0; r < N/2; r++) {
            for(int c = 0; c < M/2; c++) {
                arr[r][c+M/2] = temp[r][c];
            }
        }
    }

    public static void rotation6() {
        int[][] temp = new int[N/2][M/2];
        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < temp[0].length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        for(int r = 0; r < N/2; r++) {
            for(int c = M/2; c < M; c++) {
                arr[r][c-M/2] = arr[r][c];
            }
        }
        for(int r = N/2; r < N; r++) {
            for(int c = M/2; c < M; c++) {
                arr[r-N/2][c] = arr[r][c];
            }
        }
        for(int r = N/2; r < N; r++) {
            for(int c = 0; c < M/2; c++) {
                arr[r][c+M/2] = arr[r][c];
            }
        }
        for(int r = 0; r < N/2; r++) {
            for(int c = 0; c < M/2; c++) {
                arr[r+N/2][c] = temp[r][c];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        command = new int[N+1];

        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());
        for(int rotation = 0; rotation < R; rotation++) {
            switch (token.nextToken()) {
                case "1" :
                    rotation1();
                    break;
                case "2" :
                    rotation2();
                    break;
                case "3" :
                    rotation3();
                    break;
                case "4" :
                    rotation4();
                    break;
                case "5" :
                    rotation5();
                    break;
                case "6" :
                    rotation6();
                    break;
            }
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
    }
}
