package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node root;

    Tree() {
        root = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if(root == null) {
            root = newNode;
        } else {
            Node scan = root;
            while(true) {
                if(scan.data < data) {
                    if(scan.right == null) {
                        scan.right = newNode;
                        break;
                    } else {
                        scan = scan.right;
                    }
                } else {
                    if(scan.left == null) {
                        scan.left = newNode;
                        break;
                    } else {
                        scan = scan.left;
                    }
                }
            }
        }
    }
}

public class BJ_5639_이진검색트리 {

    static Tree tree;
    static StringBuilder output;

    public static void postorder(Node node) {
        if(node.left != null)
            postorder(node.left);
        if(node.right != null)
            postorder(node.right);
        output.append(node.data).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();
        tree = new Tree();

        String line;
        while((line = br.readLine()) != null) {
            tree.add(Integer.parseInt(line));
        }

        postorder(tree.root);
        System.out.println(output.substring(0, output.length()-1));
        br.close();
    }
}
