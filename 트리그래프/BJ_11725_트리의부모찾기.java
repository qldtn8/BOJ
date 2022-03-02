package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11725_트리의부모찾기 {

    static LinkedList<Integer>[] node;  // 인접리스트로 간선끼리 연결된 노드 정보
    static int[] parentNode;    // 2부터 N까지 부모노드 정보
    static int N;   // 입력받는 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder("");   // 결과 출력을 위한 StringBuilder
        N = Integer.parseInt(br.readLine());

        // 인접리스트 및 부모노드배열 초기화
        node = new LinkedList[N];
        for(int i = 0; i < N; i++) {
            node[i] = new LinkedList<>();
        }
        parentNode = new int[N];

        // 간선으로 연결된 노드를 인접리스트에 추가
        for(int i = 1; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            node[a-1].add(b-1);
            node[b-1].add(a-1);
        }

        // BFS를 위한 Queue 생성
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int row = queue.poll();
            for(int col : node[row]) {  // 부모노드에 연결된 자식노드를 queue에 추가하기 위함.
                if(parentNode[col] == 0) {  // 해당 노드를 방문했는 지는 parentNode[col]이 0이 아닌 것으로 판단.
                    parentNode[col] = row+1;
                    queue.offer(col);
                }
            }
        }
        for(int i = 1; i < N; i++) {
            output.append(parentNode[i]+"\n");
        }
        System.out.println(output.substring(0, output.length()-1));
    }
}
