import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int divisor = 2;
        while(N > 1) {
            if(N % divisor == 0) {
                N = N / divisor;
                bw.write(divisor + "\n");
            } else
                divisor++;
        }

        bw.flush();
        bw.close();
    }
}