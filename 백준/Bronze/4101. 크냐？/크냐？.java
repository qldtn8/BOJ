import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        while(!line.equals("0 0")) {
            StringTokenizer token = new StringTokenizer(line);
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            if(a > b)
                bw.write("Yes");
            else
                bw.write("No");
            bw.newLine();
            line = br.readLine();
        }

        bw.flush();
        bw.close();
    }
}