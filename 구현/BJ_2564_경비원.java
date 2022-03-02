package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564_경비원 {

    static int width;   // 블록의 가로의 길이
    static int height;  // 블록의 세로의 길이
    static int numOfStore;   // 상점의 수
    static int[] store;   // 상점 위치
    static int x;    // 동근이 위치
    static int total;

    public static void minimumDistance() {
        for(int i = 0; i < store.length; i++) {
            int distance = Math.abs(store[i]-x);
            if(distance > width+height) {
                total += 2*(width+height) - distance;
            } else {
                total += distance;
            }
        }
    }

    public static int findDistance(int direction, int count) {
        int temp = -1;
        switch (direction) {
            case 1 : temp = count;
                break;
            case 2 : temp = width + height + (width-count);
                break;
            case 3 : temp = width + height + width + (height-count);
                break;
            case 4 : temp = width + count;
                break;
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        width = Integer.parseInt(token.nextToken());
        height = Integer.parseInt(token.nextToken());

        numOfStore = Integer.parseInt(br.readLine());
        store = new int[numOfStore];
        for(int i = 0; i < numOfStore; i++) {
            token = new StringTokenizer(br.readLine());
            store[i] = findDistance(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }
        token = new StringTokenizer(br.readLine());
        x = findDistance(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        total = 0;
        minimumDistance();
        System.out.println(total);
    }
}
