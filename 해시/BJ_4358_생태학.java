package BJ.해시;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class BJ_4358_생태학 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new TreeMap<>();
        String line;
        int total = 0;
        while((line = br.readLine()) != null) {
            total++;
            if(map.containsKey(line)) {
                map.put(line, map.get(line)+1);
            } else {
                map.put(line, 1);
            }
        }

        for(String key : map.keySet()) {
            bw.write(key+" "+String.format("%.4f\n", map.get(key)*100/(double)total));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
