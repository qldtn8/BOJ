package BJ.정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_18870_좌표압축 {

    static class Position {
        int idx, num;
        public Position(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Position> list = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list.add(new Position(i, Integer.parseInt(token.nextToken())));
        }

        list.sort(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.num == o2.num)
                    return o1.idx - o2.idx;
                return o1.num - o2.num;
            }
        });

        int pre = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < N; i++) {
            Position p = list.get(i);
            if(p.num == pre) {
                p.num = count-1;
            } else {
                pre = p.num;
                p.num = count++;
            }
            System.out.println(pre + " " + count);
        }
        list.sort((o1, o2) -> o1.idx - o2.idx);
        for(int i = 0; i < N; i++) {
            bw.write(list.get(i).num +" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
