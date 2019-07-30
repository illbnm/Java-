package src.LRU最近最少使用;

import src.SingleListNOHEAD.Link;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

class LinkNode {
    String key;
    int value;
    LinkNode pre = null;
    LinkNode next = null;

    public LinkNode(LinkNode pre, LinkNode next) {
        this.pre = pre;
        this.next = next;
    }

    public LinkNode() {

    }
}

public class LRU {
    private HashMap<String, LinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkNode head, tail;

    public LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;   // 连接首尾
        tail.pre = head;
    }

    /**
     *  获取node的value
     * @param key
     * @return
     */
    public int get(String key) {
        LinkNode node = cache.get(key);
        if (node == null) {
            return -1; // //没有这条记录
        }
        this.moveToHead(node);
        return node.value;
    }

    public void set(String key, int value) {
        //判断key是否存在
        LinkNode node = cache.get(key);


        if (node == null) {
            LinkNode newNode = new LinkNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            // 添加
            this.add(newNode);
            ++size;
            if (size > capacity) {
                // 获取到尾节点
                LinkNode tail = this.popTail();
                // 删除尾节点
                this.cache.remove(tail.key);
                --size;
            }

        } else {
            node.value = value;
            //将其移动到链表头部
            this.moveToHead(node);

        }
    }

    /**
     * TODO : 移动到节点下一个
     * 先删除,再添加
     *
     * @param node
     */
    private void moveToHead(LinkNode node) {
        this.removeNode(node);
        this.add(node);
    }

    /**
     * 链表中添加新节点
     *
     * @param node
     */
    private void add(LinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }


    private void removeNode(LinkNode node) {
        LinkNode pre = node.pre;
        LinkNode next = node.next;
        pre.next = node.next;
        next.pre = node.pre;
    }

    public LinkNode popTail() {
        LinkNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public void ToString() {
        LinkNode node = head.next;
        while (node != tail) {
            System.out.println("key" + node.key + "   " + "value" + node.value);
            node = node.next;
        }
    }
    public static void main(String[] args) {
        LRU lru = new LRU(9);
        lru.set("1", 1);
        lru.set("2", 1);
        lru.set("3", 1);
        lru.set("4", 1);
        lru.set("1", 1);
        lru.ToString();
    }
}

