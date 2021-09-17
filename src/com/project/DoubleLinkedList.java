package com.project;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    public Node jugador1;
    public Node jugador2;
    private int size;

    public void DoubleLinkedList(){
        this.jugador1 = null;
        this.jugador2 = null;
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

    public void moveForward(int numberDice, int jugador){
        if(this.jugador1 == null && this.jugador2 == null){
            this.jugador2 = this.jugador1 = this.head;
            numberDice --;
        }
        Node current = null;
        if (jugador == 1) {
            current = this.jugador1;
        } else if (jugador == 2) {
            current = this.jugador2;
        }
        while (numberDice > 0) {
            current = current.next;
            numberDice --;
        }
        if (jugador == 1) {
            this.jugador1 = current;
        } else if (jugador == 2) {
            this.jugador2 = current;
        }
        int x,y;
        try{
            Tunel data = (Tunel) current.getData();
            data.start();
            x = data.x;
            y = data.y;
        } catch (Exception e) {
            try{
                Reto data = (Reto) current.getData();
                data.start();
                x = data.x;
                y = data.y;
            }catch (Exception n){
                Trampa data = (Trampa) current.getData();
                data.start();
                x = data.x;
                y = data.y;
            }
        }
        // con if selecciona que jugador va a mover y lo mueve a x,y
    }

    public Node getHead() {
        if (this.head == null) {
            return null;
        }else {
            return this.head;
        }
    }

}
