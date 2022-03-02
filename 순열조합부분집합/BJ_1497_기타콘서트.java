package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1497_기타콘서트 {

    static int N, M;
    static String[] guitar;
    static boolean[] isSelected;

    static int min_numOfGuitar;
    static int max_numOfMusic;

    public static void subSet(int cnt) {
        if(cnt == N) {
            int numOfGuitar = 0;
            int numOfMusic = 0;
            boolean[] canPlay = new boolean[M];
            for(int i = 0; i < isSelected.length; i++) {
                if(isSelected[i]) {
                    numOfGuitar++;
                    for(int j = 0; j < guitar[i].length(); j++) {
                        if(!canPlay[j] && guitar[i].charAt(j) == 'Y') {
                            canPlay[j] = true;
                            numOfMusic++;
                        }
                    }
                }
            }

            if(numOfGuitar != 0 && max_numOfMusic <= numOfMusic && min_numOfGuitar > numOfGuitar) {
                min_numOfGuitar = numOfGuitar;
                max_numOfMusic = numOfMusic;
            }
            return;
        }
        // 현재 기타 선택 o
        isSelected[cnt] = true;
        subSet(cnt+1);
        // 현재 기타 선택 x
        isSelected[cnt] = false;
        subSet(cnt+1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        guitar = new String[N];
        isSelected = new boolean[N];

        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            token.nextToken();
            guitar[i] = token.nextToken();
        }
        max_numOfMusic = -1;
        min_numOfGuitar = Integer.MAX_VALUE;

        subSet(0);
        if(max_numOfMusic != 0)
            System.out.println(min_numOfGuitar);
        else
            System.out.println(-1);
    }
}
