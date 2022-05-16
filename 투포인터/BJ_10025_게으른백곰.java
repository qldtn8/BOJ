package BJ.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10025_게으른백곰 {

    static class Ice implements Comparable<Ice>{
        int x, g;
        public Ice(int x, int g) {
            this.x = x;
            this.g = g;
        }

        @Override
        public int compareTo(Ice o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        ArrayList<Ice> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            list.add(new Ice(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }


    }
}
