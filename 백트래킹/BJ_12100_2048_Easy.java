package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_12100_2048_Easy {

    static int N;
    static int[][] board;
    static int max;

    // 배열에서 최대값을 찾는 메소드
    public static int fineMax(int[][] arr) {
        int temp = Integer.MIN_VALUE;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(temp < arr[r][c]) {
                    temp = arr[r][c];
                }
            }
        }
        return temp;
    }

    // 왼쪽으로 이동
    public static int[][] swipeLeft(int[][] arr) {
        int[][] newArr = new int[N][N];
        for(int r = 0; r < N; r++) {
            ArrayList<Integer> list = new ArrayList<>();    // 결과값을 저장할 ArrayList
            int pre = arr[r][0];
            for(int c = 1; c < N; c++) {
                if(pre == 0) {
                    if(arr[r][c] != 0)
                        pre = arr[r][c];
                    continue;
                }
                if(arr[r][c] == 0)
                    continue;

                if(arr[r][c] == pre) {
                    list.add(pre * 2);
                    pre = 0;
                }
                else {
                    list.add(pre);
                    pre = arr[r][c];
                }
            }
            if(pre != 0) list.add(pre);
            for(int c = 0; c < list.size(); c++) {
                newArr[r][c] = list.get(c);
            }
            for(int c = list.size(); c < N; c++) {
                newArr[r][c] = 0;
            }
        }
        return newArr;
    }

    // 오른쪽으로 이동
    public static int[][] swipeRight(int[][] arr) {
        int[][] newArr = new int[N][N];
        for(int r = 0; r < N; r++) {
            ArrayList<Integer> list = new ArrayList<>();
            int pre = arr[r][N-1];
            for(int c = N-2; c >= 0; c--) {
                if(pre == 0) {
                    if(arr[r][c] != 0)
                        pre = arr[r][c];
                    continue;
                }
                if(arr[r][c] == 0)
                    continue;

                if(arr[r][c] == pre) {
                    list.add(pre * 2);
                    pre = 0;
                }
                else {
                    list.add(pre);
                    pre = arr[r][c];
                }
            }
            if(pre != 0) list.add(pre);
            for(int c = 0; c < list.size(); c++) {
                newArr[r][N-1-c] = list.get(c);
            }
            for(int c = N-1-list.size(); c >= 0; c--) {
                newArr[r][c] = 0;
            }
        }
        return newArr;
    }

    // 위로 이동
    public static int[][] swipeUp(int[][] arr) {
        int[][] newArr = new int[N][N];
        for(int c = 0; c < N; c++) {
            ArrayList<Integer> list = new ArrayList<>();
            int pre = arr[0][c];
            for(int r = 1; r < N; r++) {
                if(pre == 0) {
                    if(arr[r][c] != 0)
                        pre = arr[r][c];
                    continue;
                }
                if(arr[r][c] == 0)
                    continue;

                if(arr[r][c] == pre) {
                    list.add(pre * 2);
                    pre = 0;
                }
                else {
                    list.add(pre);
                    pre = arr[r][c];
                }
            }
            if(pre != 0) list.add(pre);
            for(int r = 0; r < list.size(); r++) {
                newArr[r][c] = list.get(r);
            }
            for(int r = list.size(); r < N; r++) {
                newArr[r][c] = 0;
            }
        }
        return newArr;
    }

    // 아래로 이동
    public static int[][] swipeDown(int[][] arr) {
        int[][] newArr = new int[N][N];
        for(int c = 0; c < N; c++) {
            ArrayList<Integer> list = new ArrayList<>();
            int pre = arr[N-1][c];
            for(int r = N-2; r >= 0; r--) {
                if(pre == 0) {
                    if(arr[r][c] != 0)
                        pre = arr[r][c];
                    continue;
                }
                if(arr[r][c] == 0)
                    continue;

                if(arr[r][c] == pre) {
                    list.add(pre * 2);
                    pre = 0;
                }
                else {
                    list.add(pre);
                    pre = arr[r][c];
                }
            }
            if(pre != 0) list.add(pre);
            for(int r = 0; r < list.size(); r++) {
                newArr[N-1-r][c] = list.get(r);
            }
            for(int r = list.size(); r < N; r++) {
                newArr[N-1-r][c] = 0;
            }
        }
        return newArr;
    }


    // 최대 5번 이동시킬 수 있으므로 5번을 어떻게 이동할 지 순열로 구한다.
    public static void permutation2048(int nth, int[][] arr) {
        if(nth == 5) {
            int maxValue = fineMax(arr);
            if(max < maxValue) {
                max = maxValue;
            }
            return;
        }

        permutation2048(nth+1, swipeLeft(arr));
        permutation2048(nth+1, swipeRight(arr));
        permutation2048(nth+1, swipeUp(arr));
        permutation2048(nth+1, swipeDown(arr));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        // 배열입력끝------------------

        permutation2048(0, board);
        System.out.println(max);
    }
}
