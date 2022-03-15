package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2457_공주님의정원 {

    static class Flower implements Comparable<Flower> {
        int sM, sD;
        int eM, eD;
        public Flower(int sM, int sD, int eM, int eD) {
            this.sM = sM;
            this.sD = sD;
            this.eM = eM;
            this.eD = eD;
        }
        @Override
        public int compareTo(Flower o) {
            if(this.sM != o.sM) {
                return this.sM - o.sM;
            } else if(this.sD != o.sD) {
                return this.sD - o.sD;
            } else if(this.eM != o.eM) {
                return this.eM - o.eM;
            }
            return this.eD - o.eD;
        }
    }

    static int N;
    static PriorityQueue<Flower> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int sM = Integer.parseInt(token.nextToken());
            int sD = Integer.parseInt(token.nextToken());
            int eM = Integer.parseInt(token.nextToken());
            int eD = Integer.parseInt(token.nextToken());
            if(eM < 3 || sM > 11 || (sM == eM && sD == eD)) {
                System.out.println("필요없는 꽃 뺀다");
                continue;
            }
            pq.offer(new Flower(sM, sD, eM, eD));
        }

        if(pq.isEmpty()) {
            System.out.println(0);
            return;
        }

        int[] pre = {3, 1};
        Flower curr = pq.poll();
        int numOfFlowers = 1;
        while(!pq.isEmpty()) {
            Flower f = pq.poll();
            System.out.print(f.sM + "/" +f.sD + " ~ " + f.eM +"/"+f.eD);

            if(curr.eM > f.eM || (curr.eM == f.eM && curr.eD >= f.eD)) {
                System.out.println(" 선택안함;");
                continue;
            }

            if((f.sM < pre[0] || (f.sM == pre[0] && f.sD <= pre[1])) && (curr.eM < f.eM || (curr.eM == f.eM && curr.eD < f.eD))) {
                curr = f;
                System.out.println(" 이전 curr 삭제 후 지금꺼 넣는다...");
            } else if(!(f.sM < pre[0] || (f.sM == pre[0] && f.sD <= pre[1])) && (f.sM < curr.eM || (f.sM == curr.eM && f.sD <= curr.eD))) {
                pre[0] = curr.eM; pre[1] = curr.eD;
                curr = f;
                numOfFlowers++;
                System.out.println(" 추가해준다...");
            } else {
                continue;
            }

            if(f.eM > 11) {
                System.out.println(numOfFlowers);
                return;
            }
        }
        System.out.println(0);
    }
}
