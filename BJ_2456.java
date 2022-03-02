package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 나는 학급회장이다
 */
class Candidate implements Comparable<Candidate> {
    int index;
    int count1;
    int count2;
    int count3;
    int total;

    public Candidate(int index) {
        this.index = index;
    }

    void setScore(int num) {
        if(num == 1) {
            count1++;
        } else if(num == 2) {
            count2++;
        } else {
            count3++;
        }
        total += num;
    }

    @Override
    public int compareTo(Candidate o) {
        if(this.total > o.total) {
            return 1;
        } else if(this.total < o.total) {
            return -1;
        } else {
            if(this.count3 == o.count3) {
                if(this.count2 == o.count2) {
                    return 0;
                } else {
                    return Integer.compare(this.count2, o.count2);
                }
            } else {
                return Integer.compare(this.count3, o.count3);
            }
        }
    }
}

public class BJ_2456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Candidate[] candidates = {new Candidate(1), new Candidate(2), new Candidate(3)};
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            StringTokenizer token = new StringTokenizer(line, " ");
            candidates[0].setScore(Integer.parseInt(token.nextToken()));
            candidates[1].setScore(Integer.parseInt(token.nextToken()));
            candidates[2].setScore(Integer.parseInt(token.nextToken()));
        }
        Arrays.sort(candidates);
        if(candidates[2].compareTo(candidates[1]) != 0) {
            System.out.println(candidates[2].index + " " + candidates[2].total);
        } else {
            System.out.println(0 + " " + candidates[2].total);
        }
    }
}
