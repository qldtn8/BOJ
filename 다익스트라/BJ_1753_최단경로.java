package BJ.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {

    static class Vertex implements Comparable<Vertex>{
        int v;
        int weight;
        public Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.v == o.v ? Integer.compare(this.weight, o.weight) : Integer.compare(this.v, o.v);
        }
    }

    static int V;
    static int E;
    static PriorityQueue<Vertex>[] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        V = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        int start = Integer.parseInt(br.readLine())-1;

        adjMatrix = new PriorityQueue[V];
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken())-1;
            int to = Integer.parseInt(token.nextToken())-1;
            int weight = Integer.parseInt(token.nextToken());
            if(adjMatrix[from] == null) {
                adjMatrix[from] = new PriorityQueue<>();
            }
            adjMatrix[from].offer(new Vertex(to, weight));
        }
        // 입력 끝

        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for(int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE, minIdx = 0;
            for(int j = 0; j < V; j++) {
                if(!visited[j] && distance[j] < min) {
                    min = distance[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;

            if(adjMatrix[minIdx] == null) {
                continue;
            }
            while(!adjMatrix[minIdx].isEmpty()) {
                Vertex temp = adjMatrix[minIdx].poll();
                if(!visited[temp.v] && distance[temp.v] > distance[minIdx] + temp.weight) {
                    distance[temp.v] = distance[minIdx] + temp.weight;
                }
            }

        }

        StringBuilder output = new StringBuilder();
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE)
                output.append("INF\n");
            else
                output.append(distance[i]+"\n");
        }
        System.out.println(output.toString());
    }
}

/*
public class BJ_1753_최단경로 {
    static int V;
    static int E;
    static HashMap<Integer, Integer>[] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        V = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        int start = Integer.parseInt(br.readLine())-1;

        adjMatrix = new HashMap[V];
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken())-1;
            int to = Integer.parseInt(token.nextToken())-1;
            int weight = Integer.parseInt(token.nextToken());
            if(adjMatrix[from] == null) {
                adjMatrix[from] = new HashMap<>();
            }
            if(adjMatrix[from].containsKey(to) && adjMatrix[from].get(to) > weight) {
                adjMatrix[from].put(to, weight);
            } else if(!adjMatrix[from].containsKey(to)) {
                adjMatrix[from].put(to, weight);
            }
        }
        // 입력 끝

        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for(int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE, minIdx = 0;
            for(int j = 0; j < V; j++) {
                if(!visited[j] && distance[j] < min) {
                    min = distance[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;

            if(adjMatrix[minIdx] == null) {
                continue;
            }

            for(Integer key : adjMatrix[minIdx].keySet()) {
                int weight = adjMatrix[minIdx].get(key);
                if(!visited[key] && distance[key] > distance[minIdx] + weight) {
                    distance[key] = distance[minIdx] + weight;
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE)
                output.append("INF\n");
            else
                output.append(distance[i]+"\n");
        }
        System.out.println(output.toString());
    }
}
 */

/*
public class BJ_1753_최단경로 {

    static class Edge{
        int from;
        int to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int V;
    static int E;
    static LinkedList<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        V = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        int start = Integer.parseInt(br.readLine())-1;

        edges = new LinkedList<>();
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken())-1;
            int to = Integer.parseInt(token.nextToken())-1;
            int weight = Integer.parseInt(token.nextToken());
            edges.add(new Edge(from, to, weight));
        }
        // 입력 끝

        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for(int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE, minIdx = 0;
            for(int j = 0; j < V; j++) {
                if(!visited[j] && distance[j] < min) {
                    min = distance[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;

            for(int j = 0; j < edges.size(); j++) {
                if(edges.get(j).from == minIdx) {
                    int to = edges.get(j).to;
                    if(!visited[to] && distance[to] > distance[minIdx] + edges.get(j).weight) {
                        distance[to] = distance[minIdx] + edges.get(j).weight;
                        edges.remove(j--);
                    }
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE)
                output.append("INF\n");
            else
                output.append(distance[i]+"\n");
        }
        System.out.println(output.toString());
    }
}
*/

/*
public class BJ_1753_최단경로 {

    static class Vertex{
        int v;
        int weight;
        public Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static int V;
    static int E;
    static LinkedList<Vertex>[] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        V = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        int start = Integer.parseInt(br.readLine())-1;

        adjMatrix = new LinkedList[V];
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken())-1;
            int to = Integer.parseInt(token.nextToken())-1;
            int weight = Integer.parseInt(token.nextToken());
            if(adjMatrix[from] == null) {
                adjMatrix[from] = new LinkedList<>();
            }
            adjMatrix[from].add(new Vertex(to, weight));
        }
        // 입력 끝

        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for(int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE, minIdx = 0;
            for(int j = 0; j < V; j++) {
                if(!visited[j] && distance[j] < min) {
                    min = distance[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;

            if(adjMatrix[minIdx] == null) {
                continue;
            }
            for(int j = 0; j < adjMatrix[minIdx].size(); j++) {
                int v = adjMatrix[minIdx].get(j).v;
                if(!visited[v] && distance[v] > distance[minIdx] + adjMatrix[minIdx].get(j).weight) {
                    distance[v] = distance[minIdx] + adjMatrix[minIdx].get(j).weight;
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE)
                output.append("INF\n");
            else
                output.append(distance[i]+"\n");
        }
        System.out.println(output.toString());
    }
}
 */
