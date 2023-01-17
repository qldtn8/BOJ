
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] students;
    static boolean[] visited;
    static boolean[] selected;

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            students = new int[N+1];
            selected = new boolean[N+1];
            visited = new boolean[N+1];
            count = 0;

            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                students[i] = Integer.parseInt(token.nextToken());
                if(i == students[i]) {
                    selected[i] = true;
                    count++;
                }
            }

            for(int i = 1; i <= N; i++) {
                if(!selected[i])
                    dfs(i);
            }

            bw.write((N - count) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int n) {
        if(selected[n])
            return;

        if(visited[n]) {
            selected[n] = true;
            count++;
        }

        visited[n] = true;
        dfs(students[n]);
        selected[n] = true;
        visited[n] = false;
    }

}