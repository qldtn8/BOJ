package BJ.트리그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205_맥주마시면서걸어가기 {

    static class Vertex {
        int x, y;
        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static Vertex house;
    static Vertex[] convenience;
    static Vertex festival;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            house = new Vertex(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
            convenience = new Vertex[N];
            for(int i = 0; i < N; i++) {
                tokens = new StringTokenizer(br.readLine());
                convenience[i] = new Vertex(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
            }
            tokens = new StringTokenizer(br.readLine());
            festival = new Vertex(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));

            bw.write(bfs()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static String bfs() {
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(house);

        boolean[] visited = new boolean[N];

        while(!queue.isEmpty()) {
            Vertex v = queue.poll();

            if(Math.abs(festival.x - v.x) + Math.abs(festival.y - v.y) <= 1000) {
                return "happy";
            }

            for(int i = 0; i < N; i++) {
                if(!visited[i] && Math.abs(convenience[i].x - v.x) + Math.abs(convenience[i].y - v.y) <= 1000) {
                    visited[i] = true;
                    queue.offer(convenience[i]);
                }
            }
        }
        return "sad";
    }
}
