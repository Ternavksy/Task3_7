package ru.vsu.cs.shepliakovvladislavvyacheslavovich;

import java.util.List;

public class SimpleLinkedListDouble {
    public SimpleLinkedListDouble() {

    }

    public SimpleLinkedListDouble(double[] array) {
        for (int i = 0; i < array.length; i++) {
            this.addLast(array[i]);
        }
    }

    public SimpleLinkedListDouble(List<Double> list) {
        for (int i = 0; i < list.size(); i++) {
            this.addLast(list.get(i));
        }
    }

    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }

    private class SimpleLinkedListNode {
        public double value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(double value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(double value) {
            this(value, null);
        }
    }

    private SimpleLinkedListNode head = null;
    private SimpleLinkedListNode tail = null;
    private int size = 0;
    public double getMaxElementDouble() throws SimpleLinkedListException {
        checkEmptyError();
        double maxElement = getFirst();
        SimpleLinkedListNode curr = head;
        for (int i = 0; i < size(); i++) {
            double comparable = curr.value;
            if (comparable > maxElement) {
                maxElement = comparable;
            }
            curr = curr.next;
        }
        return maxElement;
    }

    public int countOfElement(double element) throws SimpleLinkedListException {
        checkEmptyError();
        int countOfElement = 0;
        SimpleLinkedListNode curr = head;
        for (int i = 0; i < size(); i++) {
            double comparable = curr.value;
            if (Double.compare(element, comparable) == 0)  {
                countOfElement++;
            }
            curr = curr.next;
        }
        return countOfElement;
    }

    public void addFirst(double value) {
        head = new SimpleLinkedListNode(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(double value) {
        if (size == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkEmptyError() throws SimpleLinkedListException {
        if (size == 0) {
            throw new SimpleLinkedListException("Empty list");
        }
    }

    private SimpleLinkedListNode getNode(int index) throws SimpleLinkedListException{
        if (index < 0 || index >= size) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        SimpleLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void removeFirst() throws SimpleLinkedListException {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    public void removeLast() throws SimpleLinkedListException {
        checkEmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
    }

    public void remove(int index) throws SimpleLinkedListException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            SimpleLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }


    public int size() {
        return size;
    }


    public double get(int index) throws SimpleLinkedListException {
        checkEmptyError();
        return getNode(index).value;
    }


    public double getFirst() throws SimpleLinkedListException {
        checkEmptyError();
        return head.value;
    }

    public double getLast() throws SimpleLinkedListException {
        checkEmptyError();
        return tail.value;
    }
}
