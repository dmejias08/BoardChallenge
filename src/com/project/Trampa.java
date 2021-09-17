package com.project;

import javax.swing.*;
import java.util.Random;

public class Trampa {
    JButton space;
    JPanel juego;
    Random r;
    public  int backward,x,y;

    public void set() {
        space = new JButton("Trampa");
        space.setSize(75,75);
        space.setLocation(x,y);
        juego.add(space);
    }
    public void start() {
        r = new Random();
        backward = 1 + r.nextInt(3);
        JOptionPane.showMessageDialog(null, "Retroceda: " + String.valueOf(backward) + "esapcios");


//    public void getCoords(){ // coordenas de la casilla de la casilla donde se moverá el jugador
//
//    }
    }
}

