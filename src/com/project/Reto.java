package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Reto extends JFrame implements ActionListener {
    ImageIcon imageClass;
    JLabel place;
    JPanel juego;
    JPanel msgBox;
    JLabel challenge;
    JTextField answer;
    JButton ask;
    Random rand = new Random();
    int x,y,a,b,op,res;
    String reto="";


    public void set() {
        imageClass = new ImageIcon("src"+Main.divider+"Images_Datos"+Main.divider+"icon_exit.png");
        place = new JLabel(imageClass);
        place.setSize(75,75);
        place.setLocation(x,y);
        juego.add(place);
        juego.repaint();
    }

    public void start() {
        op = rand.nextInt(5-1) + 1;
        a = rand.nextInt(51-1) + 1;
        b = rand.nextInt(51-1) + 1;

        setTitle("Reto");
        setVisible(true);
        setSize(300,200 );
        msgBox = new JPanel();
        this.getContentPane().add(msgBox);
        msgBox.setLayout(null);
        msgBox.setBackground(Color.decode("#bad5ff"));
        setResizable(false);

        if (op==1){
            reto=a+"+"+b;
        }
        if (op==2){
            reto=a+"-"+b;
        }
        if (op==3){
            reto=a+"/"+b;
        }
        if (op==4){
            reto=a+"*"+b;
        }

        challenge = new JLabel("¿Cuál es el valor de "+reto+"?");
        challenge.setSize(200,20);
        challenge.setLocation(60,30);
        msgBox.add(challenge);

        answer = new JTextField();
        answer.setSize(50,20);
        answer.setLocation(115,70);
        msgBox.add(answer);

        ask = new JButton("Ok");
        ask.setSize(50,20);
        ask.setLocation(115,110);
        msgBox.add(ask);
        ask.addActionListener(this::actionPerformed);
        msgBox.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            res = Integer.parseInt(answer.getText());
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null,"Sólo se permite la entrada de enteros");
            answer.setText(null);
        }
    }
}

