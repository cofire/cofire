package com.cofire.utils.basic.link;

public class IsCircle {

    public static void main(String args[]) {
        // creating LinkedList with 5 elements including head
        LinkedList linkedList = new LinkedList(null);
        LinkedList.Node head = linkedList.head();
        linkedList.add(new LinkedList.Node("1"));
        LinkedList.Node node = new LinkedList.Node("2");
        // linkedList.add(new LinkedList.Node("2"));
        linkedList.add(node);
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));
        linkedList.add(node);
        // finding middle element of LinkedList in single pass
        LinkedList.Node fast = head;
        LinkedList.Node slow = head;

        while (fast != null && fast.next() != null) {
            fast = fast.next().next();
            slow = slow.next();

            // if fast and slow pointers are meeting then LinkedList is cyclic
            if (fast == slow) {
                System.out.println("true");
                return;
            }
        }

        System.out.println("false");

    }

}
