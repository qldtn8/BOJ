package BJ.트리그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_9934_완전이진트리 {

    static int K;
    static int[] inorder;
    static LinkedList<Integer>[] depthInfo;

    public static void findKthNode(int depth, int start, int end) {
        if(depth == K) {
            return;
        }
        int mid = (start+end)/2;
        depthInfo[depth].add(inorder[mid]);
        findKthNode(depth+1, start, mid-1);
        findKthNode(depth+1, mid+1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        inorder = new int[(int)Math.pow(2, K)-1];
        depthInfo = new LinkedList[K];
        for(int i = 0; i < K; i++) {
            depthInfo[i] = new LinkedList<>();
        }

        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < inorder.length; i++) {
            inorder[i] = Integer.parseInt(token.nextToken());
        }

        findKthNode(0, 0, inorder.length-1);
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < depthInfo[i].size(); j++) {
                bw.write(depthInfo[i].get(j) + " ");
            }
            if(i != K-1) bw.write("\n");
        }
        bw.close();
    }
}
