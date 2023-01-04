import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        Set<String> keywords = new HashSet<>();
        for(int i = 0; i < N; i++) {
            keywords.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String line = br.readLine();
            for(String word : line.split(",")) {
                if(keywords.contains(word))
                    keywords.remove(word);
            }

            bw.write("" + keywords.size());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}