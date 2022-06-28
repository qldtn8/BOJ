package BJ.트리그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9177_단어섞기 {

    static class Position {
        int a, b;

        public Position(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static char[] A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int n = 1; n <= N; n++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            A = token.nextToken().toCharArray();
            B = token.nextToken().toCharArray();
            C = token.nextToken().toCharArray();

            bw.write("Data set " + n +": " + (bfs()? "yes" : "no") + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bfs() {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[A.length+1][B.length+1];

        visited[0][0] = true;
        queue.offer(new Position(0, 0));

        while(!queue.isEmpty()) {
            Position p = queue.poll();

            if(p.a + p.b == C.length) return true;

            if(p.a < A.length && A[p.a] == C[p.a + p.b] && !visited[p.a+1][p.b]) {
                visited[p.a+1][p.b] = true;
                queue.offer(new Position(p.a+1, p.b));
            }
            if(p.b < B.length && B[p.b] == C[p.a + p.b] && !visited[p.a][p.b+1]) {
                visited[p.a][p.b+1] = true;
                queue.offer(new Position(p.a, p.b+1));
            }
        }
        return false;
    }
}

/*import java.io.*;
        import java.util.StringTokenizer;

public class BJ_9177_단어섞기 {

    static String A, B, C;
    static boolean isSuccess;

    public static void shake(int n, int i, int j) {
        if(n == C.length()) {
            isSuccess = true;
            return;
        }

        if(i < A.length() && A.charAt(i) == C.charAt(n)) {
            shake(n+1, i+1, j);
        }
        if(j < B.length() && B.charAt(j) == C.charAt(n)) {
            shake(n+1, i, j+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int n = 1; n <= N; n++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            A = token.nextToken();
            B = token.nextToken();
            C = token.nextToken();

            isSuccess = false;
            shake(0, 0, 0);
            bw.write("Data set " + n +": " + (isSuccess? "yes" : "no") + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}*/
