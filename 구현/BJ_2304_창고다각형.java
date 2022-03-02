package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_2304_창고다각형 {

    static int N;
    static int[][] position;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        position = new int[N][2];

        int maxHeight = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            if(y > maxHeight) {
                maxHeight = y;
                maxIdx = x;
            }
            position[i][0] = x;
            position[i][1] = y;
        }

        Arrays.sort(position, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int index = 0;
        int height = 0;
        int sum = 0;
        while(index < N && position[index][0] <= maxIdx) {
            if(index != 0 ) sum += (position[index][0] - position[index-1][0] -1) * height;
            if(height < position[index][1]) {
                height = position[index][1];
            }
            sum += height;
            index++;
        }
        index = N-1;
        height = 0;
        while(0 <= index && position[index][0] >= maxIdx) {
            if (index != N-1) sum += (position[index + 1][0] - position[index][0] - 1) * height;
            if (height < position[index][1]) {
                height = position[index][1];
            }
            if (position[index][0] != maxIdx) sum += height;
            index--;
        }
        System.out.println(sum);
    }
}
