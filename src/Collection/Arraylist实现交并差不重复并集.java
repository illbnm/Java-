package src.Collection;

import java.util.ArrayList;
import java.util.List;

public class Arraylist实现交并差不重复并集 {


    public static void main(String[] args) {

        ArrayList alist = new ArrayList();
        ArrayList blist = new ArrayList();
        for (int i = 0; i < 10; i++) {
            alist.add(i);
        }
        for (int i = 5; i < 15; i++) {
            blist.add(i);
        }
        System.out.println(alist.toString());
        System.out.println(blist.toString());
//交集
//        alist.retainAll(blist);
//        System.out.println(alist);
// 并集
        blist.removeAll(alist);         //删除blist中与alist重复的部分
        alist.addAll(blist);            // 将blist剩余部分添加到alist
        System.out.println(alist.toString());
//  差集



    }


}
