import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static final int N = 11;

    public static int[][] player;
    public static int maxAbility;

    public static void selectPlayer(int n, int sum, int flag) {
        if(n == N) {
            if(sum > maxAbility)
                maxAbility = sum;
            return;
        }

        for(int position = 0; position < N; position++) {
            if(player[n][position] != 0 && (flag & 1 << position) == 0) {
                selectPlayer(n+1, sum + player[n][position], flag | 1 << position);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            player = new int[N][N];
            for(int r = 0; r < N; r++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++)
                    player[r][c] = Integer.parseInt(token.nextToken());
            }
            maxAbility = Integer.MIN_VALUE;
            selectPlayer(0, 0, 0);
            bw.write("" + maxAbility);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}