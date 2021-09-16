package com.project;

import javax.swing.*;
import java.util.Random;

public class Trampa {
    Random r;
    int backward;


    public void start() {
        r = new Random();
        backward = 1 + r.nextInt(3);
        JOptionPane.showMessageDialog(null, "Retroceda: " + String.valueOf(backward) + "esapcios");


//    public void getCoords(){ // coordenas de la casilla de la casilla donde se moverá el jugador
//
//    }
    }
}

