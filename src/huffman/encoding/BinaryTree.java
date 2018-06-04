package huffman.encoding;

import java.util.HashMap;

/**
 * Created by Sergey Sandalov on 03.07.2017.
 */


class Node{
    int data;
    String c;
    Node left;
    Node right;
    Node parent;

    public Node(int data, String c, Node left, Node right, Node parent){
        this.data = data;
        this.c = c;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

}

public class BinaryTree {
    Node root;
    public BinaryTree(Node root){
        this.root = root;
    }

    public static void Traverse(Node root, StringBuilder stringBuilder,HashMap<String,String> map){
        if(root != null && root.left == null){
            map.put(root.c,stringBuilder.toString());
        }else if(root != null){
            stringBuilder.append("0");
            Traverse(root.left,stringBuilder,map);
            //stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length()-1,"1");
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append("1");
            Traverse(root.right,stringBuilder,map);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }

    public HashMap<String,String> codeTable(){
        HashMap<String,String> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder("");
        Traverse(root,stringBuilder,map);
        return map;
    }
}
