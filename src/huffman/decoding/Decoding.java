package huffman.decoding;

import java.util.HashMap;
import java.util.Scanner;


public class Decoding {
    public static void decode() {
        int code_table_size;
        System.out.print("Input dictionary size: ");
        Scanner scanner = new Scanner(System.in);
        code_table_size = scanner.nextInt();

        System.out.println("Input code table: (example - a: 011)");
        scanner.nextLine();
        HashMap<String,String> codeTable = new HashMap<>();
        for(int i=0;i<code_table_size;i++){
            String tmp = scanner.nextLine();
            codeTable.put(tmp.substring(0,1),tmp.substring(3));
        }
        //scanner.nextLine();
        System.out.println("Input string to decode:");
        String s = scanner.nextLine();
        Tree tree = new Tree(new Node(null,null,null));
        tree.buildTree(codeTable);
        System.out.println("Decoded string: ");
        System.out.println(tree.decode(s));

        System.out.println();
    }
}
