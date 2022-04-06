package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15486_퇴사2 {

    static class Counsel implements Comparable<Counsel>{
        int t, p;
        public Counsel(int d, int p) {
            this.t = d;
            this.p = p;
        }

        @Override
        public int compareTo(Counsel o) {
            if(this.p == o.p)
                return this.t-o.t;
            return o.p - this.p;
        }

        @Override
        public String toString() {
            return "Counsel{" +
                    "t=" + t +
                    ", p=" + p +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Counsel> list = new ArrayList<>();
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            list.add(new Counsel(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

    }
}
