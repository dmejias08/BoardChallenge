package com.project;

public class DoubleLinkedList {
    private Node head;
    private int size;
    private Node tail;

    public void DoubleLinkedList(){
        this.head = null;
        this.size = 0;
        this.tail = null;
    }
    public boolean isEmpty(){
        if (this.head == null && this.tail == null){
            return true;
        }else {
            return false;
        }
    }
    public int size(){
        return this.size;
    }

    public void insertLast(Object data){
        Node newNode = new Node(data); //crea nodo
        this.tail.next = newNode;
        newNode.previous = this.tail;// al siguiete le guarda el primero
        newNode.next = null;
        this.tail = newNode; // se guarda en la cabeza actual
        this.size++;
    }
    public void insertFirst(Object data){
        if(this.head == null && this.tail == null) {
            this.head = new Node(data);
            this.tail = this.head;
        }else{
            
        }
    }
    public Node deleteFirst(){
        if (this.head != null){
            Node temp = this.head;
            this.head = this.head.next;
            this.head.previous = null;
            this.size--;
            return temp;

        }else {
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
        if (this.head == null && this.tail == null) {
            return null;
        }else {
            return this.head;
        }
    }
}
