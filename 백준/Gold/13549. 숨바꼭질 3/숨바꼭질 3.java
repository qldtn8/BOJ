import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Point implements Comparable<Point> {
        int x, time;

        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }

    public static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(N, 0));

        int[] visited = new int[MAX];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[N] = 0;

        while(!pq.isEmpty()) {
            Point p = pq.poll();

            if(p.x == K) {
                System.out.println(p.time);
                break;
            }

            int a = p.x * 2;
            int b = p.x + 1;
            int c = p.x - 1;

            if(a < visited.length && visited[a] > p.time) {
                visited[a] = p.time;
                pq.add(new Point(a, p.time));
            }
            if(b < visited.length && visited[b] > p.time+1) {
                visited[b] = p.time + 1;
                pq.add(new Point(b, p.time+1));
            }
            if(0 <= c && visited[c] > p.time+1) {
                visited[c] = p.time + 1;
                pq.add(new Point(c, p.time+1));
            }
        }
    }
}