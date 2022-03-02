package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2477_참외밭 {

    static int K;   // 1m^2의 넓이에 자라는 참외의 개수
    static int[][] area;    // 육각형의 꼭지점 정보 [0] 방향 [1] 거리
    static int width;   // 참외밭의 가로길이
    static int widthIdx;    // area의 몇번째 인덱스에 저장되어있는 지
    static int height;  // 참외밭의 세로길이
    static int heightIdx;   // area의 몇번째 인덱스에 저장되어있는 지

    public static int[] findEmptySide() {
        int count = 0;
        int index = widthIdx;
        int[] temp = new int[2];
        while(true) {
            index = (index + 1) % 6;
            count++;
            if(index == heightIdx) {
                count = 0;
                continue;
            }
            if(count == 2) temp[0] = index;
            if(count == 3) {
                temp[1] = index;
                break;
            }
        }
        return temp;
    }

    public static int emptyArea() {

        int[] index = findEmptySide();
        return width*height - (area[index[0]][1]*area[index[1]][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        area = new int[6][2];

        width = 0;
        height = 0;
        StringTokenizer token;
        for(int i = 0; i < 6; i++) {
            token = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(token.nextToken());
            int distance = Integer.parseInt(token.nextToken());
            if(direction == 1 || direction == 2) {
                if(distance > width) {
                    width = distance;
                    widthIdx = i;
                }
            } else {
                if(distance > height) {
                    height = distance;
                    heightIdx = i;
                }
            }

            area[i][0] = direction;
            area[i][1] = distance;
        }
        System.out.println(emptyArea()*K);
    }
}
