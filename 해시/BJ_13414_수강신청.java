package BJ.해시;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_13414_수강신청 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(token.nextToken());
        int L = Integer.parseInt(token.nextToken());

        Set<String> set = new LinkedHashSet<>();
        for(int i = 0; i < L; i++) {
            String studentId = br.readLine();
            if(set.contains(studentId))
                set.remove(studentId);
            set.add(studentId);
        }

        Iterator<String> iterator = set.iterator();
        int k = 0;
        while(iterator.hasNext() && k++ < K) {
            bw.write(iterator.next()+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
