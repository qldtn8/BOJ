package BJ.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_2002_추월 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            map.put(br.readLine(), i);
        }

        boolean[] check = new boolean[N+1];
        int count = 0;
        for(int i = 1; i <= N; i++) {
            String carNum = br.readLine();
            check[map.get(carNum)] = true;
            if(i < map.get(carNum))
                count++;
            else if(i == map.get(carNum)) {
                for(int j = 1; j < map.get(carNum); j++) {
                    if(!check[j]) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
