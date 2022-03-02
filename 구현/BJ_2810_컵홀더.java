package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2810_컵홀더 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int cupholder = 0;
        // 자리의 왼쪽자리만 확인!!
        for(int i = 0; i < N; i++) {
            if(line.charAt(i) == 'S') {
                cupholder++;
            } else if(line.charAt(i) == 'L') {
                cupholder++;
                i++;
            }
        }
        cupholder++;    // 맨 오른쪽 자리 컵홀더
        System.out.println(cupholder > N? N : cupholder);
    }
}
