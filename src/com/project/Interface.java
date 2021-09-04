package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Interface extends JFrame implements ActionListener{

    public JPanel pane;
    public JButton dice;
    public JLabel labelDice;
    public int dice_result;

    public Interface(){

        setTitle("Math Socket");
        setVisible(true);
        setSize(800,700 );
        pane = new JPanel();
        this.getContentPane().add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.decode("#bad5ff"));

        dice = new JButton("Dice");
        dice.setSize(60,40);
        dice.setLocation(700,30);
        dice.addActionListener( this);
        pane.add(dice);

        labelDice = new JLabel("");
        labelDice.setSize(60,40);
        labelDice.setLocation(700, 60);
        labelDice.setFont(new Font("Girassol",Font.PLAIN,18));
        pane.add(labelDice);

        setResizable(false);
        pane.repaint();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random diceR = new Random();
        dice_result = 1 + diceR.nextInt(4);
        labelDice.setText(String.valueOf(dice_result));
//        try {
//            Thread.sleep(1000);
//            labelDice.setText("");
//    } catch (InterruptedException ex) {
//        ex.printStackTrace();
//        }
    }
}


