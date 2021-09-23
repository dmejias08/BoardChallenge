package com.project;

import javax.swing.*;
import java.util.Random;

public class Trampa {
    JLabel space;
    JPanel juego;
    Random r;
    ImageIcon imgTunel;
    public  int backward,x,y;

    public void set() {
        imgTunel = new ImageIcon("src/Images_Datos/trampa.png");
        space = new JLabel(imgTunel);
        space.setSize(75,75);
        space.setLocation(x,y);
        juego.add(space);
    }
    public int start() {
        r = new Random();
        backward = 1 + r.nextInt(3);
        JOptionPane.showMessageDialog(null, "Retroceda: " + String.valueOf(backward) + " esapcios");
        return backward;
    }
}

