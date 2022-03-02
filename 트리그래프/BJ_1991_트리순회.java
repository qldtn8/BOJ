package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1991_트리순회 {

    static int N;
    static String[][] tree;
    static StringBuilder output;

    public static void preorderDFS(String current) {
        output.append(current);
        if(!tree[current.charAt(0)-65][0].equals(".")) {
            preorderDFS(tree[current.charAt(0)-65][0]);
        }
        if(!tree[current.charAt(0)-65][1].equals(".")) {
            preorderDFS(tree[current.charAt(0)-65][1]);
        }
    }

    public static void inorderDFS(String current) {
        if(!tree[current.charAt(0)-65][0].equals(".")) {
            inorderDFS(tree[current.charAt(0)-65][0]);
        }
        output.append(current);
        if(!tree[current.charAt(0)-65][1].equals(".")) {
            inorderDFS(tree[current.charAt(0)-65][1]);
        }
    }

    public static void postorderDFS(String current) {
        if(!tree[current.charAt(0)-65][0].equals(".")) {
            postorderDFS(tree[current.charAt(0)-65][0]);
        }
        if(!tree[current.charAt(0)-65][1].equals(".")) {
            postorderDFS(tree[current.charAt(0)-65][1]);
        }
        output.append(current);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        tree = new String[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            String root = token.nextToken();
            tree[root.charAt(0)-65][0] = token.nextToken();
            tree[root.charAt(0)-65][1] = token.nextToken();
        }
        preorderDFS("A");
        output.append("\n");
        inorderDFS("A");
        output.append("\n");
        postorderDFS("A");
        System.out.println(output);
    }
}
