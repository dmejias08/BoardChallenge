package com.project;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tunel {
    JButton space;
    JPanel juego;
    Random r;
    int forward,x,y;

    public void set() {
        space = new JButton("Tunel");
        space.setSize(75,75);
        space.setLocation(x,y);
        space.setBackground(Color.RED);
        space.setEnabled(false);
        juego.add(space);
        juego.repaint();
    }

    public void start() {
        r = new Random();
        forward = 1 + r.nextInt(3);
        JOptionPane.showMessageDialog(null,"Avance: "+String.valueOf(forward)+"esapcios");
    }



//    public void getCoords(){
//
//    }


}
