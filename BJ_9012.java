package BJ;

import java.io.*;

/**
 * 괄호
 */
public class BJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            if(str.length() % 2 != 0) {
                bw.write("NO\n");
                continue;
            }
            int count = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '(') {
                    count++;
                } else {
                    if (count > 0) {
                        count--;
                    } else {
                        count--;
                        break;
                    }
                }
            }
            if(count == 0) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
            if(i != (T-1)) {
                bw.newLine();
            }
        }
        br.close();
        bw.close();
    }
}
