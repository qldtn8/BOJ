package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_5639_이진검색트리_2 {

    static LinkedList<Integer> postorder;
    static StringBuilder output;

    public static void postDFS(int start, int end) {
        if(start < end) {
            int rightSS = end;
            for(int i = start+1; i < end; i++) {
                if(postorder.get(i) > postorder.get(start)) {
                    rightSS = i;
                    break;
                }
            }
            if(start+1 != rightSS) {
                postDFS(start + 1, rightSS);
            }
            postDFS(rightSS, end);
            output.append(postorder.get(start)+"\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();
        postorder = new LinkedList<>();

        String line;
        while((line = br.readLine()) != null) {
            postorder.add(Integer.parseInt(line));
        }
        postDFS(0, postorder.size());
        System.out.println(output.substring(0, output.length()-1));

        br.close();
    }
}
