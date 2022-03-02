package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1068_트리 {

    static int N;   // 노드의 개수
    static LinkedList<Integer>[] tree;  // 이차원 연결리스트(?)
    static int root;    // 루트의 노드 번호
    static int removeNode;  // 삭제할 노드 번호
    static int removeParent;    // 삭제할 노드 번호의 부모번호

    public static int findLeafNode(int current) {
        // tree[current]가 비어있으면 자식이 없는 것으로 리프노드가 된다.
        if(tree[current].isEmpty()) {
            return  1;
        }
        int sum = 0;
        for(int i = 0; i < tree[current].size(); i++) {
            sum += findLeafNode(tree[current].get(i));
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        // 이차원연결리스트(?) 초기화
        tree = new LinkedList[N];
        for(int i = 0; i < N; i++) {
            // tree[i] 에는 i 의 자식을 저장.
            tree[i] = new LinkedList<>();
        }

        StringTokenizer token = new StringTokenizer(br.readLine()); // 0번 노드~ N-1번 노드까지 각 노드의 부모정보
        removeNode = Integer.parseInt(br.readLine());   // 지울 노드의 번호
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(token.nextToken());
            if(parent == -1) {  // 부모노드의 번호가 -1 이면 루트
                root = i;
            } else {
                tree[parent].add(i);    // tree[parent]에 i 자식 노드 추가.
            }

            if(i == removeNode) {
                removeParent = parent;
            }
        }

        if(removeNode != root) {    // 지울 노드의 번호가 루트노드가 아니면
            // tree[지울노드의 부모번호]에 저장된 자식인 removeNode를 삭제
            tree[removeParent].remove(tree[removeParent].indexOf(removeNode));
            System.out.println(findLeafNode(root));
        } else {    // 지울 노드의 번호가 루트노드이면 리프노드 무조건 0
            System.out.println(0);
        }
    }
}
