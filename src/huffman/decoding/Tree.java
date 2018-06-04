package huffman.decoding;

import java.util.HashMap;
import java.util.Map;

class Node{
    String ch;
    Node left;
    Node right;

    public Node(String ch, Node left, Node right){
        this.ch = ch;
        this.left = left;
        this.right = right;
    }

}
public class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void buildTree(HashMap<String,String> codeTable){
        Node tmp = root;
        for(Map.Entry entry: codeTable.entrySet()){
            String ch = (String) entry.getKey();
            String str = (String) entry.getValue();
            for(int i=0;i< str.length();i++){
                if(str.substring(i,i+1).equals("0")){
                    if(tmp.left == null){
                        Node node = new Node(null,null,null);
                        tmp.left = node;
                    }
                    tmp = tmp.left;
                }else if(str.substring(i,i+1).equals("1")){
                    if(tmp.right == null){
                        Node node = new Node(null,null,null);
                        tmp.right = node;
                    }
                    tmp = tmp.right;
                }

            }
            tmp.ch = ch;
            tmp = root;
        }
    }

    public String decode(String s){
        StringBuilder str = new StringBuilder();
        Node tmp = root;
        for(int i=0;i<=s.length();i++){
            if(tmp.left==null && tmp.right==null){
                str.append(tmp.ch);
                tmp = root;
                if(i!=s.length())
                    i = i-1;
            }else{
                if(s.substring(i,i+1).equals("0")){
                    if(tmp.left == null) {
                        tmp = root;
                        i = i-1;
                    }
                    else
                        tmp = tmp.left;
                }else if(s.substring(i,i+1).equals("1")){
                    if(tmp.right == null) {
                        tmp = root;
                        i = i - 1;
                    }
                    else
                        tmp = tmp.right;
                }
            }

        }
        return str.toString();
    }
}
