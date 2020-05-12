package com.cofire.utils.basic.link;

public class ReverseLinkenList {
    public static void reverse(LinkedList linkedList) {
        LinkedList.Node pointer = linkedList.head();
        LinkedList.Node previous = null;
        LinkedList.Node current = null;
        while (pointer != null) {
            current = pointer;
            pointer = pointer.next();

            // reverse the link
            current.setNext(previous);
            previous = current;
            linkedList.setHead(current);
        }
        linkedList.print();
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
        reverse(linkedList);
    }
}
