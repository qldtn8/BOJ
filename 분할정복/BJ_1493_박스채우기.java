package BJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1493_박스채우기 {

    static int length, width, height;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        length = Integer.parseInt(token.nextToken());
        width = Integer.parseInt(token.nextToken());
        height = Integer.parseInt(token.nextToken());

        N = Integer.parseInt(br.readLine());

    }
}
