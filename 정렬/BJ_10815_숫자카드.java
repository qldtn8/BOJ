package BJ.정렬;


import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_10815_숫자카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> tree = new TreeSet<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(token.nextToken()));
        }

        int M =Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            if(tree.contains(Integer.parseInt(token.nextToken()))) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
