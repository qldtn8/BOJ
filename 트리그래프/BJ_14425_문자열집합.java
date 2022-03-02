package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_14425_문자열집합 {

    static int N;
    static int M;

    static LinkedList<String>[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        set = new LinkedList['z'-'a'+1];

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            set[word.charAt(0)].add(word);
        }



    }
}
