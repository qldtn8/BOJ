package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_18428_감시피하기 {

    static int N;
    static char[][] corridor;
    static LinkedList<int[]> teacher;

    public static boolean watch() {
        for(int[] t : teacher) {
            // 위에 감시
            for(int r = t[0]-1; r >= 0; r--) {
                if(corridor[r][t[1]] =='O') break;
                if(corridor[r][t[1]] == 'S') return false;
            }
            // 아래 감시
            for(int r = t[0]+1; r < N; r++) {
                if(corridor[r][t[1]] =='O') break;
                if(corridor[r][t[1]] == 'S') return false;
            }
            // 오른쪽 감시
            for(int c = t[1]+1; c < N; c++) {
                if(corridor[t[0]][c] == 'O') break;
                if(corridor[t[0]][c] == 'S') return false;
            }
            for(int c = t[1]-1; c >= 0; c--) {
                if(corridor[t[0]][c] == 'O') break;
                if(corridor[t[0]][c] == 'S') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        corridor = new char[N][N];
        teacher = new LinkedList<>();

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                corridor[i][j] = token.nextToken().charAt(0);
                if(corridor[i][j] == 'T') {
                    teacher.add(new int[]{i, j});
                }
            }
        }

    }
}
