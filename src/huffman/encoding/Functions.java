package huffman.encoding;

import java.util.ArrayList;
import java.util.HashMap;

public class Functions {
    public static HashMap<String , Integer> freq(String s){
        HashMap<String,Integer> map = new HashMap<>();
        String  c;
        for(int i = 0;i<s.length();i++){
            c =  s.substring(i,i+1);
            if(map.containsKey(c)){
                int value = map.get(c);
                map.put(c,value+1);
            }else{
                map.put(c,1);
            }
        }

        return map;
    }

    public static Node extractMin(ArrayList<Node> arr){
        Node min = arr.get(0);
        int min_index = 0;
        for(int k=1;k<arr.size();k++){
            if(arr.get(k).data<min.data) {
                min = arr.get(k);
                min_index = k;
            }
        }

        arr.remove(min_index);
        return min;
    }



}

