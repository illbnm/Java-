package src.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListtest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        //在将泛型参数固定之后,就只能添加固定参数类型的数据 .
        // 添加
        arrayList.add(0, 3);
        arrayList.add(1, 3);
        arrayList.add(3);

//遍历 将所有的数据查询出来
        // 1 . for循环遍历
        // 2. for each 遍历
        for (Integer a : arrayList) {
            System.out.println(a + " ");
        }
        //3. 迭代器 方式遍历 遍历工具
        Iterator<Integer> arraylistor = arrayList.iterator();
        while (arraylistor.hasNext()) {//判断是否还有下一个元素
            Integer a = arraylistor.next();//通过next()获取下一个元素
            System.out.println(a);
        }
//删除
        // 1. 删除指定元素
        arrayList.remove("1");
        // 2. 按指定位置删除
        arrayList.remove(0);
//改变
        // 1.通过下标改变元素的值
        arrayList.set(1, 80);
//判断元素是否存在
        // 1.根据值判断
        boolean s = arrayList.contains(1);
        System.out.println(s);
        System.out.println(arrayList.toString());
// 批量添加
        ArrayList alist = new ArrayList();
        // 批量添加元素,指添加ArrayList元素(必须是同一类型)
        arrayList.addAll(alist);
        // 向指定位置添加时,原来的位置之后的元素会后移
        arrayList.addAll(2, alist);

        //通过构造函数添加
        ArrayList<Integer> arrayList1 = new ArrayList<>(alist);
//批量删除
        //1.删除指定的集合
        arrayList1.removeAll(alist);
        //2. 在arraylist1删除alist里面没有的元素(求交集)
        arrayList1.retainAll(alist);
//转成数组
        // 1.转成Object数组
        Object[] objects = arrayList.toArray();
        // 2.
        Integer[] integer = new Integer[alist.size()];
        arrayList.toArray(integer);
//转成子list
        //子序列为左闭右开区间 [0,2)
        List<Integer> n = alist.subList(0, 2);
    }
}
