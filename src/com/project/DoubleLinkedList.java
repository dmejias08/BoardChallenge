package com.project;

import javax.swing.*;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    public Node jugador1;
    public Node jugador2;
    private int size;
//    public Reto dataRe;
    public int jugadorActual;
    public boolean noGanador = true;

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

    public void moveForward(int numberDice, int jugador){
        jugadorActual=jugador;
        if(this.jugador1 == null && jugador == 1){
            this.jugador1= this.head;
            numberDice --;
        }
        if (this.jugador2 == null && jugador == 2){
            this.jugador2= this.head;
            numberDice --;
        }

        Node current = null;
        if (jugador == 1) {
            current = this.jugador1;
        } else if (jugador == 2) {
            current = this.jugador2;
        }
        while (numberDice > 0) {
            if (current==null || current.next==null){
                if (numberDice>=1) {
                    if (jugador == 1) {
                        Interface.jug1.setLocation(640, 500);
                        JOptionPane.showMessageDialog(null, "Felicidades el ganador es "+Main.home.s_player1);
                    } else {
                        Interface.jug2.setLocation(640, 500 + 30);
                        JOptionPane.showMessageDialog(null, "Felicidades el ganador es "+Main.home.s_player2);
                    }
                    Main.home.example.dispose();
                    Main.home.setVisible(true);
                    noGanador=false;
                } else {
                    break;
                }
                numberDice=0;
            } else {
                current = current.next;
                numberDice --;
            }
        }
        if (jugador == 1) {
            this.jugador1 = current;
        } else if (jugador == 2) {
            this.jugador2 = current;
        }
        int x,y;
        if (noGanador) {
            if (current.getData() instanceof Tunel) {
                Tunel dataTu = (Tunel) current.getData();
                x = dataTu.x;
                y = dataTu.y;
                if (jugador == 1) {
                    Interface.jug1.setLocation(x, y);
                } else {
                    Interface.jug2.setLocation(x, y + 30);
                }
                moveTuTr(dataTu.start(), jugador, true);

            } else if (current.getData() instanceof Reto) {
                Reto dataRe = (Reto) current.getData();
                x = dataRe.x;
                y = dataRe.y;
                if (jugador == 1) {
                    Interface.jug1.setLocation(x, y);
                    JOptionPane.showMessageDialog(null, "Reto para "+Main.home.s_player2);
                } else {
                    Interface.jug2.setLocation(x, y + 30);
                    JOptionPane.showMessageDialog(null, "Reto para "+Main.home.s_player1);
                }
                dataRe.start();
                Main.home.example.dice.setEnabled(false);

            } else if (current.getData() instanceof Trampa) {
                Trampa dataTr = (Trampa) current.getData();
                x = dataTr.x;
                y = dataTr.y;
                if (jugador == 1) {
                    Interface.jug1.setLocation(x, y);
                } else {
                    Interface.jug2.setLocation(x, y + 30);
                }
                moveTuTr(dataTr.start(), jugador, false);
            }
        }
    }

    public void moveTuTr(int number, int jugador, boolean forward) {
        Node current = null;
        if (jugador == 1) {
            current = this.jugador1;
        } else if (jugador == 2) {
            current = this.jugador2;
        }
        while (number > 0) {
            if (forward) {
                if (current==null || current.next == null) {
                    if (number>=1) {
                        if (jugador == 1) {
                            Interface.jug1.setLocation(640, 500);
                            JOptionPane.showMessageDialog(null, "Felicidades el ganador es "+Main.home.s_player1);
                        } else {
                            Interface.jug2.setLocation(640, 500 + 30);
                            JOptionPane.showMessageDialog(null, "Felicidades el ganador es "+Main.home.s_player2);
                        }
                        Main.home.example.dispose();
                        Main.home.setVisible(true);
                        noGanador=false;
                    } else {
                        break;
                    }
                    number=0;
                } else {
                    current = current.next;
                }
            } else if (forward == false) {
                if (current == null || current.previous == null) {
                    break;
                }else{
                    current = current.previous;
                }
            }
            number--;
        }
        if (jugador == 1) {
            this.jugador1 = current;
        } else if (jugador == 2) {
            this.jugador2 = current;
        }
        int x, y;
        if (noGanador) {
            if (current.getData() instanceof Tunel) {
                Tunel dataTu = (Tunel) current.getData();
                x = dataTu.x;
                y = dataTu.y;
                if (jugador == 1) {
                    Interface.jug1.setLocation(x, y);
                } else {
                    Interface.jug2.setLocation(x, y + 30);
                }
            } else if (current.getData() instanceof Reto) {
                Reto dataRe = (Reto) current.getData();
                x = dataRe.x;
                y = dataRe.y;
                if (jugador == 1) {
                    Interface.jug1.setLocation(x, y);
                } else {
                    Interface.jug2.setLocation(x, y + 30);
                }
            } else if (current.getData() instanceof Trampa) {
                Trampa dataTr = (Trampa) current.getData();
                x = dataTr.x;
                y = dataTr.y;
                if (jugador == 1) {
                    Interface.jug1.setLocation(x, y);
                } else {
                    Interface.jug2.setLocation(x, y + 30);
                }
            }
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
