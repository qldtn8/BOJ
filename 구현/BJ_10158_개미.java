package BJ.구현;

import java.io.*;

public class BJ_10158_개미 {

    static int H, W;
    static int x, y;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        W = Integer.parseInt(temp[0]);
        H = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");
        x = Integer.parseInt(temp[0]);
        y = Integer.parseInt(temp[1]);

        t = Integer.parseInt(br.readLine());

        if(((x + t) / W) % 2 == 0) {
            x = (x+t) % W;
        } else {
            x = W - (x+t) % W;
        }
        if(((y + t) / H) % 2 == 0) {
            y = (y+t) % H;
        } else {
            y = H - (y+t) % H;
        }
        StringBuilder output = new StringBuilder();
        output.append(x + " " + y);
        System.out.println(output);
    }
}

/*
T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            x += deltas[d][0];
            y += deltas[d][1];

            if(x == 0 && y == 0) {
                d = 0;
            } else if(x == 0 && y == H) {
                d = 1;
            } else if(x == W && y == 0) {
                d = 3;
            } else if(x == W && y == H) {
                d = 2;
            } else if(x == 0) { // 왼쪽변
                d = d == 3 ? 0 : 1;
            } else if(x == W) { // 오른쪽변
                d = d == 0 ? 3 : 2;
            } else if(y == 0) { // 아래변
                d = d == 1 ? 0 : 3;
            } else if(y == H) { // 윗변
                d = d == 0 ? 1 : 2;
            }
        }
        System.out.println(x + " " + y);
 */
