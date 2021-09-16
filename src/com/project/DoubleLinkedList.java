package com.project;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size(){
        return this.size;
    }

    public void insertLast(Object data){
        Node newNode = new Node(data);
        newNode.previous = this.tail;
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            if (this.size==1) {
                this.head.next = newNode;
            }
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.size++;
    }

    public Node deleteFirst(){
        if (this.tail != null) {
            Node temp = this.head;
            this.head = this.head.next;
            this.head.previous = null;
            this.size--;
            return temp;
        } else {
            return null;
        }
    }

    public void displayList(){
        Node current = this.head;
        while (current != null){
            System.out.println(current.getData());
            current = current.next;
        }
    }
    public Node getHead() {
        if (this.head == null) {
            return null;
        }else {
            return this.head;
        }
    }

}
