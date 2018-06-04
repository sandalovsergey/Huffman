package huffman.encoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Encoding {
    public static void encode() {
        String s;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to encode:");
        s = scanner.nextLine();
        HashMap<String,Integer> map = Functions.freq(s);
        HashMap<String,String> codeTable;

        if(map.size() == 1) {
            codeTable = new HashMap<>();
            for(Map.Entry entry: map.entrySet()){
                codeTable.put((String) entry.getKey(),"0");
            }
        }else {
            ArrayList<Node> queue = new ArrayList<>();
            for (Map.Entry entry : map.entrySet()) {
                Node node = new Node((int) entry.getValue(), (String) entry.getKey(), null, null, null);
                queue.add(node);
            }

            for (int k = 0; k < map.size() - 1; k++) {
                Node i = Functions.extractMin(queue);
                Node j = Functions.extractMin(queue);

                Node node = new Node(i.data + j.data, i.c + j.c, i, j, null);
                i.parent = node;
                j.parent = node;
                queue.add(node);
            }

            BinaryTree tree = new BinaryTree(queue.get(0));
            codeTable = tree.codeTable();

        }


        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            answer.append(codeTable.get(s.substring(i, i + 1)));
        }

        String greatAnswer = answer.toString();


        System.out.println();
        System.out.println("Dictionary size: " + map.size());
        System.out.println("Dictionary: ");
        for(Map.Entry entry: codeTable.entrySet()){
            System.out.println( entry.getKey()+": " + entry.getValue());
        }

        System.out.print("Encoded string: ");
        System.out.println(greatAnswer);
        System.out.println("It's length: "+ greatAnswer.length());

        //   System.out.println();

    }
}
