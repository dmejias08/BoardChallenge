package com.project;

import javax.swing.*;
import java.util.Random;

public class Tunel {
    Random r;
    int forward;

    public void start() {
        r = new Random();
        forward = 1 + r.nextInt(3);
        JOptionPane.showMessageDialog(null,"Avance: "+String.valueOf(forward)+"esapcios");
    }



//    public void getCoords(){
//
//    }


}
