package BJ.정렬;

import java.io.*;
import java.util.*;

public class BJ_1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        Set<String> set = new TreeSet<>();
        ArrayList<String> list = new ArrayList<>();
        if(N < M) {
            for(int i = 0; i < N; i++) {
                list.add(br.readLine());
            }
            for(int i = 0; i < M; i++) {
                set.add(br.readLine());
            }
        } else {
            for(int i = 0; i < N; i++) {
                set.add(br.readLine());
            }
            for(int i = 0; i < M; i++) {
                list.add(br.readLine());
            }
        }

        list.sort(Comparator.naturalOrder());
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < list.size(); i++) {
            if(set.contains(list.get(i))) {
                queue.offer(list.get(i));
            }
        }

        bw.write(queue.size()+"\n");
        while(!queue.isEmpty()) {
            bw.write(queue.poll()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
