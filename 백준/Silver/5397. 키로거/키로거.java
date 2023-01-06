import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String line = br.readLine();

            List<Character> pw = new LinkedList<>();
            int index = 0;
            for(char c : line.toCharArray()) {
                if(c == '<') {
                    if(--index < 0) index = 0;
                } else if(c == '>') {
                    if(++index > pw.size()) index = pw.size();
                } else if(c == '-') {
                    if(0 < index && index <= pw.size())
                        pw.remove(--index);
                } else {
                    pw.add(index++, c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : pw) {
                sb.append(c+"");
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}