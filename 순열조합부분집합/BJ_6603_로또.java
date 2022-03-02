package BJ.순열조합부분집합;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 로또
 */
public class BJ_6603_로또 {

    static int K;
    static int[] numbers;
    static int[] selected;
    static StringBuilder output = new StringBuilder("");

    public static void combination(int cnt, int start) {
        if(cnt == 6) {
            for(int i = 0; i < selected.length; i++) {
                output.append(selected[i] + " ");
            }
            output.delete(output.length()-1, output.length()).append("\n");
            return;
        }
        for(int i = start; i < K; i++) {
            selected[cnt] = numbers[i];
            combination(cnt+1, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while(!(line = br.readLine()).equals("0")) {
            StringTokenizer token = new StringTokenizer(line);
            K = Integer.parseInt(token.nextToken());
            numbers = new int[K];
            selected = new int[6];
            for(int i = 0; i < K; i++) {
                numbers[i] = Integer.parseInt(token.nextToken());
            }

            combination(0, 0);

            output.append("\n");

        }
        output.delete(output.length()-1, output.length());
        bw.write(output.toString());
        br.close();
        bw.close();
    }
}
