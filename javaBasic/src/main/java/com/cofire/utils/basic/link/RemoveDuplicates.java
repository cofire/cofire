package com.cofire.utils.basic.link;

public class RemoveDuplicates {
    /**
     * 删除乱序链表中的重复元素
     * 
     * @param linkedList
     */
    public static LinkedList remove_duplicates(LinkedList linkedList) {
        LinkedList.Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = linkedList.head();
        while (ptr1 != null && ptr1.next() != null) {
            ptr2 = ptr1;

            /*
             * Compare the picked element with rest of the elements
             */
            while (ptr2.next() != null) {

                /* If duplicate then delete it */
                if (ptr1.data() == ptr2.next().data()) {

                    /* sequence of steps is important here */
                    dup = ptr2.next();
                    ptr2.setNext(ptr2.next().next());
                    System.gc();
                } else /* This is tricky */ {
                    ptr2 = ptr2.next();
                }
            }
            ptr1 = ptr1.next();
        }
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new LinkedList.Node("1"));
        // LinkedList.Node head = linkedList.head();
        // linkedList.add(new LinkedList.Node("1"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.print();
        linkedList = remove_duplicates(linkedList);
        linkedList.print();
    }
}
