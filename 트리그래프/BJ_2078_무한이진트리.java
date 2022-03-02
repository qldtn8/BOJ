package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2078_무한이진트리 {

    static int A;
    static int B;

    static int L;
    static int R;

    public static void findRoot2(int a, int b) {
        while(a != 1 || b != 1) {
            if(b > a) {
                int k = 1;
                while(true) {
                    if(b - a*k > 0) {
                        k++;
                    } else {
                        k--;
                        break;
                    }
                }
                R += k;
                b = b-a*k;
            } else if(a > b) {
                int k = 1;
                while(true) {
                    if(a - b*k > 0) {
                        k++;
                    } else {
                        k--;
                        break;
                    }
                }
                L += k;
                a = a-b*k;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());
        L = R = 0;

        findRoot2(A, B);
        System.out.println(L + " " + R);
    }
}
