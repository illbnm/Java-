package src.Collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class HashTableTEST {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable();

        hashtable.put("hello", 0);
        hashtable.put("hello1", 1);
        hashtable.put("hello2", 2);
        // 遍历
        // 1. value的枚举
        Enumeration<Integer> enumeration = hashtable.elements();
        while (enumeration.hasMoreElements()) {
            Integer integer = enumeration.nextElement();
            System.out.println(integer);
        }
        //2.key的枚举


        //3. keyset的枚举
        Iterator keyset = hashtable.keySet().iterator();
        while (keyset.hasNext()) {
            System.out.print(keyset.next()+"    ");
        }
        Iterator entryset = hashtable.entrySet().iterator();
        while(entryset.hasNext()){
            System.out.println(entryset.next()+"    ");
        }


    }
}
