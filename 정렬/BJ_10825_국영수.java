package BJ.정렬;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_10825_국영수 {

    static class Student implements Comparable<Student>{
        String name;
        int s1, s2, s3; // 국어, 영어, 수학
        public Student(String name, int s1, int s2, int s3) {
            this.name = name;
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        @Override
        public int compareTo(Student o) {
            if(this.s1 != o.s1) {
                return o.s1-this.s1;
            } else if(this.s2 != o.s2) {
                return this.s2-o.s2;
            } else if(this.s3 != o.s3) {
                return o.s3-this.s3;
            }
            int index1 = 0;
            int index2 = 0;
            while(index1 < this.name.length() && index2 < o.name.length()) {
                if(this.name.charAt(index1) != o.name.charAt(index2)) {
                    return this.name.charAt(index1) - o.name.charAt(index2);
                }
                index1++;
                index2++;
            }
            if(index1 >= this.name.length()) {
                return -1;
            }
            if(index2 >= o.name.length()) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Student> pq = new PriorityQueue<>();
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            pq.offer(new Student(token.nextToken(), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }
        br.close();

        while(!pq.isEmpty()) {
            bw.write(pq.poll().name+"\n");
        }
        bw.flush();
        bw.close();
    }
}
