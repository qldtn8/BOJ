package BJ;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 프린터 큐
 */
public class BJ_1966 {

    public static boolean isHighPriority(LinkedList<Integer> list) {
        int first = list.getFirst();

        for(int i = 1; i < list.size(); i++) {
            if(first < list.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(br.readLine());
            LinkedList<Integer> queue = new LinkedList<>();
            for(int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(token.nextToken()));
            }

            int printCount = 0;
            while(true) {
                if(!isHighPriority(queue)) {   // 가장 앞에 있는 문서의 중요도가 나머지 문서들보다 낮으면
                    queue.add(queue.removeFirst()); // 맨 뒤로 보내기
                    if(M == 0) {    // 궁금한 문서가 맨 앞에 있었을 경우 위치를 맨뒤로 보내준다.
                        M = queue.size() - 1;
                    } else {
                        M--;
                    }
                } else {    // 가장 앞에 있는 문서의 중요도가 나머지 문서들보다 크거나 같으면
                    printCount++;
                    if(M == 0) {
                        break;
                    } else {
                        queue.removeFirst();
                        M--;
                    }
                }
            }
            bw.write(String.valueOf(printCount));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
