package huffman;

import huffman.decoding.Decoding;
import huffman.encoding.Encoding;

import java.util.Scanner;

/**
 * Created by Sergey Sandalov on 04.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Select mode: ");
        System.out.println("1 - Encode string");
        System.out.println("2 - Decode string");
        System.out.println("0 - Exit");

        Scanner scan = new Scanner(System.in);
        int choose = scan.nextInt();

        switch (choose){
            case 1:
                Encoding.encode();
                break;
            case 2:
                Decoding.decode();
                break;
            default:
                break;

        }
    }
}
