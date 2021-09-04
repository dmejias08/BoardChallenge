package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {

    public static Interface example;
    public static Reto reto;
    public static void main(String[] args) {
	 example = new Interface();
	 reto = new Reto();
	 reto.start(example.pane,50,50);
    }
}
class Reto extends JFrame implements ActionListener {
    JButton space;
    JPanel msgBox;
    JLabel challenge;
    JTextField answer;
    JButton ask;
    Random rand = new Random();
    int a,b,op,res;
    String reto="";

    public void start(JPanel juego, int x, int y) {
        op = rand.nextInt(5-1) + 1;
        a = rand.nextInt(51-1) + 1;
        b = rand.nextInt(51-1) + 1;
        space = new JButton("Ok");
        space.setSize(75,75);
        space.setLocation(x,y);
        juego.add(space);


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

class Tunel{
    Random forward;


}

class Trampa{

}

class Lista{

}

