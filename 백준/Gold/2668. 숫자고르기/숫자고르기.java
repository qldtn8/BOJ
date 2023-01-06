import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] line;
    public static Set<Integer> selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        line = new int[N+1];
        for(int i = 1; i <= N; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }

        selected = new TreeSet<>();
        for(int n = 1; n <= N; n++) {
            if(selected.contains(n)) continue;
            bfs(n);

        }

        bw.write(selected.size() + "\n");
        for (Integer s : selected) {
            bw.write(s+ "");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(int sn) {
        boolean[] visited = new boolean[N+1];
        visited[sn] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sn);

        while(!queue.isEmpty()) {
            int num = queue.poll();

            if(line[num] == sn) {
                for(int n = 1; n <= N; n++) {
                    if(visited[n]) selected.add(n);
                }
                break;
            }

            if(!visited[line[num]]) {
                visited[line[num]] = true;
                queue.add(line[num]);
            }
        }
    }
}