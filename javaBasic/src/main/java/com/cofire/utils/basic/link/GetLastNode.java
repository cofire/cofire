package com.cofire.utils.basic.link;

public class GetLastNode {
    /**
     * 获取链表倒数第n个节点的值
     * 
     * @param linkedList
     * @param n
     * @return
     */
    public static String getLastNNode(LinkedList linkedList, int n) {
        LinkedList.Node fast = linkedList.head();
        LinkedList.Node slow = linkedList.head();
        int start = 1;
        while (fast.next() != null) {
            fast = fast.next();
            start++;
            if (start > n) {
                slow = slow.next();
            }
        }
        return slow.data();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new LinkedList.Node("1"));
        // LinkedList.Node head = linkedList.head();
        // linkedList.add(new LinkedList.Node("1"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));
        linkedList.print();
        System.out.println(getLastNNode(linkedList, 1));
        System.out.println(getLastNNode(linkedList, 2));
        System.out.println(getLastNNode(linkedList, 3));
    }
}
