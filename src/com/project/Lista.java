package com.project;
import java.util.Random;

public class Lista {
    Tunel tunel;
    Reto reto;
    Trampa trampa;
    public DoubleLinkedList elements;
    Random rand = new Random();
    int x,y,casilla,tu,tr,re;

    public void create() {
        elements = new DoubleLinkedList();
        x=100 ;
        y=50;
        tu=0;
        tr=0;
        re=0;
        while (y<=500){
            casilla = rand.nextInt(4-1) + 1;
            if (casilla==1 & tu<4){
                tunel = new Tunel();
                tunel.x=x;
                tunel.y=y;
                tunel.juego=Main.example.pane;
                tunel.set();
                elements.insertLast(tunel);
                tu++;
                x=x+150;
            }
            else if (casilla==2 & tr<4){
                trampa = new Trampa();
                trampa.x=x;
                trampa.y=y;
                trampa.juego=Main.example.pane;
                trampa.set();
                elements.insertLast(trampa);
                tr++;
                x=x+150 ;
            }
            else if (casilla==3 & re<8){
                reto = new Reto();
                reto.x=x;
                reto.y=y;
                reto.juego=Main.example.pane;
                reto.set();
                elements.insertLast(reto);
                re++;
                x=x+150 ;
            }

            if (x>600){
                x=100;
                y=y+150;
            }
        }
    }
    public void moveForward(int spaces,int x, int y, Node node){


    }
}
