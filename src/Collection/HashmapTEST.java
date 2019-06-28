package src.Collection;

import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashmapTEST {
    public static void main(String[] args) {
        HashMap H = new HashMap();
        H.put("1", "11");
        H.put("2", "22");
        H.put("3", "33");

        System.out.println(H.toString());
        H.remove("3");
        System.out.println(H.toString());
        H.replace("1", "1111");
        boolean ret = H.containsValue("111");
        System.out.println(ret);
        Iterator<Map.Entry<String, String>> entryIterator = H.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry cur = entryIterator.next();
            System.out.println(cur.getKey() + "  " + cur.getValue());
        }
        Iterator<String> keyIter = H.keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            System.out.println(key + "    " + H.get(key));
        }
        Iterator<String> valIter = H.values().iterator();
        while (valIter.hasNext()) {
            System.out.println(valIter.next());
        }


        H.containsKey(1);

    }
}
