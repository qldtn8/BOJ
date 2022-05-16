package BJ.해시;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1620_나는야포켓몬마스터이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        Map<String, Integer> orderByAlpha = new HashMap<>();
        Map<Integer, String> orderByIndex = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            orderByAlpha.put(pokemon, i);
            orderByIndex.put(i, pokemon);
        }

        for(int i = 0; i < M; i++) {
            String temp = br.readLine();
            if(temp.chars().allMatch(Character::isDigit)) {
                bw.write(orderByIndex.get(Integer.parseInt(temp))+"\n");
            } else {
                bw.write(orderByAlpha.get(temp)+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
