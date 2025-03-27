/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author Alex Lee Chia Hau
 * @author Koh Yoke Yieng
 * @author Cham Yee
 * @author Tang Yi Jun
 */
public class DoublyLinkedList<T extends Comparable<T>> implements ListInterface<T> {

    private Node<T> firstNode; // reference to first node
    private Node<T> lastNode; // reference to last node
    private int numberOfEntries; // number of entries in list

    public DoublyLinkedList() {
        clear();
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.prev = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
        }

        numberOfEntries++;
        return true;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) { // case 1: remove first entry
                result = firstNode.data;
                if (numberOfEntries == 1) {
                    lastNode = null;
                } else {
                    firstNode.next.prev = null;
                }
                firstNode = firstNode.next;
            } else { // case 2: givenPosition > 1
                Node<T> nodeToRemove = getNodeAt(givenPosition);
                result = nodeToRemove.data;
                Node<T> nodeBefore = nodeToRemove.prev;
                Node<T> nodeAfter = nodeToRemove.next;

                nodeBefore.next = nodeAfter;
                if (nodeAfter != null) {
                    nodeAfter.prev = nodeBefore;
                } else {
                    lastNode = nodeBefore;
                }
            }

            numberOfEntries--;
        }

        return result;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node<T> node = getNodeAt(givenPosition);
            if (node != null) {
                result = node.data;
            }
        }

        return result;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private Node<T> getNodeAt(int givenPosition) {
        Node<T> currentNode = firstNode;
        for (int i = 1; i < givenPosition; ++i) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public boolean replace(int givenPosition, T anEntry) {
        boolean isSuccessful = false;

        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node<T> currentNode = firstNode;

            // Traverse to the node at the given position
            for (int i = 1; i < givenPosition; i++) {
                currentNode = currentNode.next;
            }

            // Update the data of the node at the given position
            currentNode.data = anEntry;

            isSuccessful = true;
        }

        return isSuccessful;
    }

    @Override
    public void mergeSort() {
        firstNode = mergeSort(firstNode);
    }

    private Node<T> mergeSort(Node<T> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<T> second = split(node);
        node = mergeSort(node);
        second = mergeSort(second);
        return merge(node, second);
    }

    private Node<T> merge(Node<T> first, Node<T> second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        if (first.data.compareTo(second.data) <= 0) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    private Node<T> split(Node<T> head) {
        Node<T> fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node<T> temp = slow.next;
        slow.next = null;
        return temp;
    }

    private class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> prev;

        private Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
