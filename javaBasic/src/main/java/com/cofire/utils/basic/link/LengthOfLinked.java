package com.cofire.utils.basic.link;

public class LengthOfLinked {

    /**
     * 获取链表的长度
     * 
     * @param linkedList
     * @return
     */
    public static int lengthOfLinked(LinkedList linkedList) {
        LinkedList.Node current = linkedList.head();
        int length = 0;
        while (current != null) {
            length++;
            current = current.next();
        }
        return length;
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
        System.out.println(lengthOfLinked(linkedList));
    }
}
