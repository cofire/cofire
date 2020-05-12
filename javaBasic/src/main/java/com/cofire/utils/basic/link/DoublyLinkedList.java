package com.cofire.utils.basic.link;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void setHead(Node<T> node) {
        this.head = node;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void addNode(Node<T> node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public static class Node<T> {
        private T data;
        private Node<T> previous;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public String toString() {
            return this.data.toString();
        }
    }

    public void print() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println("");
    }
}
