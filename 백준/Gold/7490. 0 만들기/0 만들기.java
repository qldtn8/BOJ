import java.io.*;

public class Main {

    static int N;
    static BufferedWriter bw;

    public static void dfs(int nth, int prev, int sum, StringBuilder sb) throws IOException {
        if(nth == N+1) {
            sum += prev;
            if(sum == 0) {
                bw.write(sb.toString());
                bw.newLine();
            }
            return;
        }

        // 공백인경우
        dfs(nth+1, prev < 0 ? prev * 10 - nth : prev * 10 + nth, sum, new StringBuilder(sb.toString() + " " + nth));

        // + 인경우
        dfs(nth+1, nth, sum + prev, new StringBuilder(sb.toString() + "+" + nth));

        // - 인경우
        dfs(nth+1, nth * -1, sum + prev, new StringBuilder(sb.toString() + "-" + nth));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            N = Integer.parseInt(br.readLine());
            dfs(2, 1, 0, new StringBuilder("1"));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}