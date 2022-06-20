package BJ.해시;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_5107_마니또 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N;
        int t = 1;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            Map<String, String> map = new HashMap<>();
            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), st.nextToken());
            }

            int cycle = 0;
            for (String key : new ArrayList<>(map.keySet())) {
                String value = map.remove(key);
                if(value == null) continue;

                while (true) {
                    value = map.remove(value);
                    if (key.equals(value)) {
                        cycle++;
                        break;
                    }
                }
            }
            bw.write(t + " " + cycle + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
