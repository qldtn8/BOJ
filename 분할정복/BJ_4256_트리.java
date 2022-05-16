package BJ.분할정복;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_4256_트리 {

    static int N;
    static int preorder[];
    static int inorder[];
    static int index;
    static BufferedWriter bw;

    public static void postorder(int left, int right) throws IOException {
        if(right == left) return;
        if(right - left == 1) {
            bw.write(preorder[index++]+" ");
            return;
        }

        int i;
        for(i = left; i < right; i++) {
            if (inorder[i] == preorder[index]) break;
        }
        int curr = index++;
        postorder(left, i);
        postorder(i+1, right);
        bw.write(preorder[curr] + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            preorder = new int[N];
            inorder = new int[N];
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                preorder[i] = Integer.parseInt(tokens.nextToken());
            tokens = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                inorder[i] = Integer.parseInt(tokens.nextToken());

            index = 0;
            postorder(0, N);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
