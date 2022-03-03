package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {

    static int N;
    static LinkedList<Integer> numbers;
    static int[] operators;
    static int max, min;

    public static void calculate(int nth, int result) {
        if(nth == N-1) {
            if(max < result) {
                max = result;
            }
            if(min > result) {
                min = result;
            }
            return;
        }
        for(int i = 0; i < operators.length; i++) {
            if(operators[i] != 0) {
                operators[i]--;
                switch (i) {
                    case 0 : calculate(nth+1, result+numbers.get(nth+1));
                        break;
                    case 1 : calculate(nth+1, result-numbers.get(nth+1));
                        break;
                    case 2 : calculate(nth+1, result*numbers.get(nth+1));
                        break;
                    case 3 :
                        if(result < 0)
                            calculate(nth+1, -((-result)/numbers.get(nth+1)));
                        else
                            calculate(nth+1, result/numbers.get(nth+1));
                        break;
                }
                operators[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new LinkedList<>();

        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(token.nextToken()));
        }

        operators = new int[4];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(token.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        calculate(0, numbers.get(0));
        System.out.println(max+"\n"+min);
    }
}
