package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class CCTV {
    int no; // CCTV 종류 번호
    int x;  // CCTV 위치
    int y;

    public CCTV(int no, int x, int y) {
        this.no = no;
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "CCTV{" +
                "no=" + no +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

public class BJ_15683_감시 {

    static int R, C;
    static int[][] office;
    static LinkedList<CCTV> cctvs;
    //static int blindspot;   // 0의 개수
    static int MIN_BlindSpot;

    public static int[][] getNewArr(int[][] arr) {
        int[][] newArr = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    // 오른쪽 탐색
    public static int[][] cctv1(int r, int c, int[][] arr) {
        int[][] newArr = getNewArr(arr);
        for(int col = c+1; col < C; col++) {
            if(newArr[r][col] == 0) {
                newArr[r][col] = -1;
            }
            if(newArr[r][col] == 6) {
                break;
            }
        }
        return newArr;
    }

    // 왼쪽 탐색
    public static int[][] cctv2(int r, int c, int[][] arr) {
        int[][] newArr = getNewArr(arr);
        for(int col = c-1; col >= 0; col--) {
            if(newArr[r][col] == 0) {
                newArr[r][col] = -1;
            }
            if(newArr[r][col] == 6) {
                break;
            }
        }
        return newArr;
    }

    // 위쪽 탐색
    public static int[][] cctv3(int r, int c, int[][] arr) {
        int[][] newArr = getNewArr(arr);
        for(int row = r-1; row >= 0; row--) {
            if(newArr[row][c] == 0) {
                newArr[row][c] = -1;
            }
            if(newArr[row][c] == 6) {
                break;
            }
        }
        return newArr;
    }

    // 아래쪽 탐색
    public static int[][] cctv4(int r, int c, int[][] arr) {
        int[][] newArr = getNewArr(arr);
        for(int row = r+1; row < R; row++) {
            if(newArr[row][c] == 0) {
                newArr[row][c] = -1;
            }
            if(newArr[row][c] == 6) {
                break;
            }
        }
        return newArr;
    }

    /**
     * @param nth   현재 몇 번째 cctv를 확인해야하는 지(인덱스)
     * @param arr   이 전까지의 cctv를 확인한 사무실.
     */
    public static void combination(int nth, int[][] arr) {
        if(nth == cctvs.size()) {
            int total = 0;
            for(int[] a : arr) {
                for(int b : a) {
                    if(b == 0) {
                        total++;
                    }
                }
            }
            if(total < MIN_BlindSpot) {
                MIN_BlindSpot = total;
            }
            return;
        }
        CCTV cctv = cctvs.get(nth);
        switch (cctv.no) {
            case 1 :
                combination(nth+1, cctv1(cctv.x, cctv.y, arr));
                combination(nth+1, cctv2(cctv.x, cctv.y, arr));
                combination(nth+1, cctv3(cctv.x, cctv.y, arr));
                combination(nth+1, cctv4(cctv.x, cctv.y, arr));
                break;
            case 2 :
                combination(nth+1, cctv1(cctv.x, cctv.y, cctv2(cctv.x, cctv.y, arr)));
                combination(nth+1, cctv3(cctv.x, cctv.y, cctv4(cctv.x, cctv.y, arr)));
                break;
            case 3 :
                combination(nth+1, cctv1(cctv.x, cctv.y, cctv3(cctv.x, cctv.y, arr)));
                combination(nth+1, cctv1(cctv.x, cctv.y, cctv4(cctv.x, cctv.y, arr)));
                combination(nth+1, cctv2(cctv.x, cctv.y, cctv3(cctv.x, cctv.y, arr)));
                combination(nth+1, cctv2(cctv.x, cctv.y, cctv4(cctv.x, cctv.y, arr)));
                break;
            case 4 :
                combination(nth+1, cctv1(cctv.x, cctv.y, cctv2(cctv.x, cctv.y, cctv3(cctv.x, cctv.y, arr))));
                combination(nth+1, cctv1(cctv.x, cctv.y, cctv2(cctv.x, cctv.y, cctv4(cctv.x, cctv.y, arr))));
                combination(nth+1, cctv1(cctv.x, cctv.y, cctv3(cctv.x, cctv.y, cctv4(cctv.x, cctv.y, arr))));
                combination(nth+1, cctv2(cctv.x, cctv.y, cctv3(cctv.x, cctv.y, cctv4(cctv.x, cctv.y, arr))));
                break;
            case 5 :
                combination(nth+1, cctv1(cctv.x, cctv.y, cctv2(cctv.x, cctv.y, cctv3(cctv.x, cctv.y, cctv4(cctv.x, cctv.y, arr)))));
                break;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        office = new int[R][C];
        cctvs = new LinkedList<>();
        for(int r = 0; r < R; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < C; c++) {
                int temp = Integer.parseInt(token.nextToken());
                office[r][c] = temp;
                if(temp != 0 && temp != 6) {
                    cctvs.add(new CCTV(temp, r, c));
                }
            }
        }
        // ---------------입력끝-----------------
        MIN_BlindSpot = Integer.MAX_VALUE;
        combination(0, office);
        System.out.println(MIN_BlindSpot);
    }
}
