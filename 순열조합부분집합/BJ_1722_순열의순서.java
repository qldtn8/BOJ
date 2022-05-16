package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1722_순열의순서 {

    static int N;
    static int k;
    static int[] arr;

    static int count;
    static boolean problemFirst;
    static boolean done;

    public static void permutation(int nth, int[] choosed, int flag) {
        if(nth == N) {
            count++;
            if(problemFirst) {
                if(count == k) {
                    arr = choosed;
                    done = true;
                }
            } else {
                for(int i = 0; i < N; i++) {
                    if(choosed[i] != arr[i]) return;
                }
                k = count;
                done = true;
            }
            return;
        }

        for(int i = 1; i <= N; i++) {
            if((flag & 1 << i) == 0) {
                choosed[nth] = i;
                permutation(nth+1, choosed, flag | 1 << i);
                if(done) return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        if(token.nextToken().equals("1")) {
            k = Integer.parseInt(token.nextToken());
            problemFirst = true;
        } else {
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
        }

        done = false;
        permutation(0, new int[N], 0);
        if(problemFirst) {
            for(int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        } else
            System.out.println(count);
    }
}
