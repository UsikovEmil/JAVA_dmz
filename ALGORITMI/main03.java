package ALGORITMI;

public class main03 {
    public static void main(String[] args) {
        revers<Integer> list = new revers<>(1, 2, 3, 4);
        list.reverse();
    }
}

public class revers<T> {
    private Node head;

    @SafeVarargs
    public revers(T... values) {
        Node previous = null;
        for (T value : values) {
            Node node = new Node();
            node.setValue(value);
            if (previous != null) {
                previous.setNext(node);
            } else {
                head = node;
            }
            previous = node;
        }
    }

    public revers<T> reverse() {
        Node node = head;
        Node previous = null;
        while (node != null) {
            Node tmp = node.getNext();
            node.setNext(previous);
            previous = node;
            head = node;
            node = tmp;
        }
        return this;
    }

    private class Node {
        private Node next;
        private T value;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}

