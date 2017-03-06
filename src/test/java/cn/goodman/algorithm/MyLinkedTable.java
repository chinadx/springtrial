package cn.goodman.algorithm;

/**
 * Created by Shaun on 2017/3/6.
 */
public class MyLinkedTable {

    /**
     * 节点
     * @param <T>
     */
    static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        public boolean equals(Node<T> node) {
            if(node.data.equals(data)) {
                return true;
            } else {
                return false;
            }
        }
    }

    static class LinkedTable<T> {
        Node<T> head;
        private int pos = 0;

        public Node<T> deleteByPos( int index) {
            Node<T> current = head;
            Node<T> previous = head;
            while ( pos != index) {
                pos++;
                previous = current;
                current = current. next;
            }
            if(current == head) {
                head = head. next;
            } else {
                pos = 0;
                previous. next = current. next;
            }
            return current;
        }

        public Node<T> deleteByData( int data) {
            Node<T> current = head;
            Node<T> previous = head;
            while (!current.data.equals(data)) {
                if (current.next == null) {
                    return null;
                }
                previous = current;
                current = current. next;
            }
            if(current == head) {
                head = head.next;
            } else {
                previous.next = current.next;
            }
            return current;
        }
    }
}
