import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int[] counts = new int[7];
        counts[0] = Integer.MIN_VALUE;
        while(token.hasMoreTokens()) {
            int num = Integer.parseInt(token.nextToken());
            counts[num]++;
        }

        int maxIndex = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 1; i <= 6; i++) {
            if(counts[maxIndex] < counts[i])
                maxIndex = i;
            if(counts[i] != 0 && maxValue < i)
                maxValue = i;
        }

        if(counts[maxIndex] == 3) {
            System.out.println(10000 + maxIndex * 1000);
        } else if(counts[maxIndex] == 2) {
            System.out.println(1000 + maxIndex * 100);
        } else {
            System.out.println(maxValue * 100);
        }
    }
}