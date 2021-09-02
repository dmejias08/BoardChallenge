package com.project;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {

    public JPanel pane;
    public JButton dice;

    public Interface(){

        setTitle("Math Socket");
        setVisible(true);
        setSize(800,600 );
        pane = new JPanel();
        this.getContentPane().add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.decode("#bad5ff"));

        dice = new JButton("Dice");
        dice.setSize(60,40);
        dice.setLocation(700,30);
        pane.add(dice);

        setResizable(false);
        pane.repaint();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
