package com.project;

public class DoubleLinkedList {
    public cliente client;
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
        client = new cliente();
        if(this.jugador1 == null && this.jugador2 == null){
            this.jugador2 = this.head;
            this.jugador1= this.head;
            numberDice --;
        }
        Node current = null;
        if (jugador == 1) {
            current = this.jugador1;
        } else if (jugador == 2) {
            current = this.jugador2;
        }
        while (numberDice > 0) {
            if (current.next==null){
                break;
            }
            current = current.next;
            numberDice --;
        }
        if (jugador == 1) {
            this.jugador1 = current;
        } else if (jugador == 2) {
            this.jugador2 = current;
        }
        int x,y;
        if (current.getData() instanceof Tunel){
            Tunel dataTu = (Tunel) current.getData();
            x = dataTu.x;
            y = dataTu.y;
            Interface.jug1.setLocation(x,y);
            moveTuTr(dataTu.start(),jugador,true);

        } else if (current.getData() instanceof Reto){
            Reto dataRe = (Reto) current.getData();
            x = dataRe.x;
            y = dataRe.y;
            Interface.jug1.setLocation(x,y);
            dataRe.start();
            client.send(dataRe.retoNum,dataRe.res);
            if (client.isAcierto()==false) {
                if (jugador == 1 && jugador1.next != null) {
                    moveTuTr(1, 2, false);
                } else if (jugador == 2 && jugador2.next != null) {
                    moveTuTr(1, 1, false);
                }
                moveTuTr(1, jugador, true);
            }

        } else if (current.getData() instanceof Trampa){
            Trampa dataTr = (Trampa) current.getData();
            x = dataTr.x;
            y = dataTr.y;
            Interface.jug1.setLocation(x,y);
            moveTuTr(dataTr.start(),jugador,false);
        }
    }

    public void moveTuTr(int number, int jugador, boolean forward){
        Node current = null;
        if (jugador == 1) {
            current = this.jugador1;
        } else if (jugador == 2) {
            current = this.jugador2;
        }
        while (number > 0) {
            if (forward){
                if (current.next==null){
                    break;
                }
                current = current.next;
            } else if (forward==false) {
                if (current.previous==null){
                    break;
                }
                current = current.previous;
            }
            number --;
        }
        if (jugador == 1) {
            this.jugador1 = current;
        } else if (jugador == 2) {
            this.jugador2 = current;
        }
        int x,y;
        if (current.getData() instanceof Tunel){
            Tunel dataTu = (Tunel) current.getData();
            x = dataTu.x;
            y = dataTu.y;
            Interface.jug1.setLocation(x,y);
        } else if (current.getData() instanceof Reto){
            Reto dataRe = (Reto) current.getData();
            x = dataRe.x;
            y = dataRe.y;
            Interface.jug1.setLocation(x,y);
        } else if (current.getData() instanceof Trampa){
            Trampa dataTr = (Trampa) current.getData();
            x = dataTr.x;
            y = dataTr.y;
            Interface.jug1.setLocation(x,y);
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
