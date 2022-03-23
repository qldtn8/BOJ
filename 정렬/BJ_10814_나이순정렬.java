package BJ.정렬;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_10814_나이순정렬 {

    static class Member implements Comparable<Member>{
        int index;
        int age;
        String name;
        public Member(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if(this.age == o.age) {
                return this.index - o.index;
            }
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Member> pq = new PriorityQueue<>();

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            pq.offer(new Member(i, Integer.parseInt(token.nextToken()), token.nextToken()));
        }
        br.close();

        while(!pq.isEmpty()) {
            bw.write(pq.poll().toString()+"\n");
        }
        bw.flush();
        bw.close();
    }
}
