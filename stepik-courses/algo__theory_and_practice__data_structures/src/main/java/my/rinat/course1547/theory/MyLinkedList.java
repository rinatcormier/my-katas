package my.rinat.course1547.theory;

public class MyLinkedList {

    private Element head;
    private Element tail;
    private int size;

    public void addFirst(Element element) {
        if (head != null) {
            Element temp = head;
            element.setNext(temp);
            temp.setPrev(element);
        }
        head = element;
        if (head.getNext() == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(Element element) {
        if (tail != null) {
            Element temp = tail;
            element.setPrev(temp);
            temp.setNext(element);
        }
        tail = element;
        if (tail.getPrev() == null) {
            head = tail;
        }
        size++;
    }

    public Element get(int index) {
        int i = 0;
        Element current = head;
        while (i != index) {
            current = current.next;
            i++;
        }
        return current;
    }

    public int size() {
        return size;
    }

    static class Element {

        private int value;
        private Element prev;
        private Element next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }
}
