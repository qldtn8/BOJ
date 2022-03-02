package BJ.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18352_특정거리의도시찾기 {

    static class Vertex implements Comparable<Vertex>{
        int index, d;
        public Vertex(int index, int d) {
            this.index = index;
            this.d = d;
        }
        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken())-1;

        LinkedList<Integer>[] adjList = new LinkedList[N];
        for(int i = 0; i < N; i++) {
         adjList[i] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;
            if(!adjList[a].contains(b)) {
                adjList[a].add(b);
            }
        }
        // 입력 끝...


        int[] distance = new int[N];
        boolean[] visited = new boolean[N];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;
        pq.offer(new Vertex(X, distance[X]));

        while(!pq.isEmpty()) {
            Vertex curr = pq.poll();
            if(visited[curr.index]) continue;

            visited[curr.index] = true;

            for(int i = 0; i < adjList[curr.index].size(); i++) {
                int nextIdx = adjList[curr.index].get(i);
                if(!visited[nextIdx] && distance[nextIdx] > curr.d + 1) {
                    distance[nextIdx] = curr.d + 1;
                    pq.offer(new Vertex(nextIdx, distance[nextIdx]));
                }
            }
        }
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(distance[i] == K) {
                System.out.println((i+1));
                count++;
            }
        }
        if(count == 0) {
            System.out.println(-1);
        }
    }
}

/*
public class BJ_18352_특정거리의도시찾기 {

    static class Vertex implements Comparable<Vertex>{
        int index, d;
        public Vertex(int index, int d) {
            this.index = index;
            this.d = d;
        }
        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken())-1;

        LinkedList<Integer>[] adjList = new LinkedList[N];
        for(int i = 0; i < N; i++) {
         adjList[i] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(token.nextToken())-1].add(Integer.parseInt(token.nextToken())-1);
        }
        // 입력 끝...


        int[] distance = new int[N];
        boolean[] visited = new boolean[N];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;
        pq.offer(new Vertex(X, distance[X]));

        StringBuilder output = new StringBuilder();
        while(!pq.isEmpty()) {
            Vertex curr = pq.poll();
            if(visited[curr.index]) continue;

            if(curr.d == K) {
                output.append((curr.index+1)+"\n");
                visited[curr.index] = true;
                continue;
            }

            visited[curr.index] = true;

            for(int i = 0; i < adjList[curr.index].size(); i++) {
                int nextIdx = adjList[curr.index].get(i);
                if(!visited[nextIdx] && distance[nextIdx] > curr.d + 1) {
                    distance[nextIdx] = curr.d + 1;
                    pq.offer(new Vertex(nextIdx, distance[nextIdx]));
                }
            }
        }
        System.out.println(output.toString().equals("") ? -1 : output);
    }
}
 */
