package com.project;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tunel {
    JLabel space;
    JPanel juego;
    Random r;
    ImageIcon imgTrampa;
    public int forward,x,y;

    public void set() {
        imgTrampa = new ImageIcon("src/Images_Datos/tunel.png");
        space = new JLabel(imgTrampa);
        space.setSize(75,75);
        space.setLocation(x,y);
        juego.add(space);
    }

    public int start() {
        r = new Random();
        forward = 1 + r.nextInt(3);
        JOptionPane.showMessageDialog(null,"Avance: "+String.valueOf(forward)+" esapcios");
        return forward;
    }
}
