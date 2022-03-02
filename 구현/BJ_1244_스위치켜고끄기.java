package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기 {

    static int N = 9;
    static boolean[] switchs;

    public static void swap(int index) {
        switchs[index] = switchs[index] ? false : true;
    }

    // 남학생
    public static void change1(int index) {
        for(int i = index, temp=1; i*temp-1 < N; temp++) {
            swap(i*temp-1);
        }
    }

    // 여학생
    public static void change2(int index) {
        int temp = 0;
        while(index-temp >= 0 && index+temp < N) {
            if(switchs[index-temp] == switchs[index+temp]) {
                temp++;
            } else {
                break;
            }
        }

        for(temp = temp-1; temp > 0; temp--) {
            swap(index-temp);
            swap(index+temp);
        }
        swap(index);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        switchs = new boolean[N];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            if(token.nextToken().equals("1"))
                switchs[i] = true;
        }
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            token = new StringTokenizer(br.readLine());
            switch (token.nextToken()) {
                case "1" : change1(Integer.parseInt(token.nextToken()));
                    break;
                case "2" : change2(Integer.parseInt(token.nextToken())-1);
                    break;
            }
        }
        StringBuilder output = new StringBuilder();
        int count = 0;
        for(boolean s : switchs) {
            output.append(s ? "1 " : "0 ");
            if(++count % 20 == 0) {
                output.append("\n");
            }
        }
        System.out.println(output.substring(0, output.length()));
    }
}
