import java.io.*;
import java.util.Arrays;

public class Main {

    public static final int MAX = 123456 * 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] removed = new boolean[MAX + 1];

        int num = 2;
        while(num <= MAX) {

            for(int i = num * 2; i <= MAX; i += num) {
                if(!removed[i])
                    removed[i] = true;
            }

            while(++num <= MAX) {
                if(!removed[num])
                    break;
            }
        }


        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;

            int count = 0;
            for(int i = n+1; i <= 2*n; i++) {
                if(!removed[i])
                    count++;
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}