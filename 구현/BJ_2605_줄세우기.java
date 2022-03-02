package BJ.구현;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_2605_줄세우기 {

    static LinkedList<Integer> students;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        students = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            students.add(students.size()-Integer.parseInt(token.nextToken()), i+1);
        }
        for(int i = 0; i < students.size(); i++) {
            bw.write(students.get(i) + " ");
        }
        br.close();
        bw.close();
    }
}
