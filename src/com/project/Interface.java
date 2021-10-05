package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Interface extends JFrame implements ActionListener{

    ImageIcon imagJug1;
    ImageIcon imagJug2;
    public JPanel pane;
    public JButton dice;
    public JButton back;
    public JLabel labelDice;
    public JLabel labelGame1;
    public JLabel labelGame2;
    public JLabel labelGame3;
    public static JLabel jug2;
    public static JLabel jug1;
    public int dice_result;
    public ImageIcon imagBack;
    private int jugador = 1;

    public Interface(){
        imagBack = new ImageIcon("src/Images_Datos/exit_icon.png");

        setTitle("Math Socket");
        setVisible(true);
        setSize(800,700 );
        pane = new JPanel();
        this.getContentPane().add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.decode("#bad5ff"));

        dice = new JButton("Dice");
        dice.setSize(80,50);
        dice.setLocation(700,25);
        dice.addActionListener( this::actionPerformed);
        pane.add(dice);

        back = new JButton("Back");
        back.setSize(60, 40);
        back.setLocation(600, 600);
        back.addActionListener(this);
        pane.add(back);

        labelDice = new JLabel("");
        labelDice.setSize(60,40);
        labelDice.setLocation(700, 65);
        labelDice.setFont(new Font("Girassol",Font.PLAIN,18));
        pane.add(labelDice);

        labelGame1 = new JLabel("Reto : Verde ");
        labelGame1.setSize(300,300);
        labelGame1.setLocation(650, 100);
        labelGame1.setFont(new Font("Girassol",Font.PLAIN,18));
        pane.add(labelGame1);

        labelGame2 = new JLabel("Tunel : Menta ");
        labelGame2.setSize(300,300);
        labelGame2.setLocation(650, 150);
        labelGame2.setFont(new Font("Girassol",Font.PLAIN,18));
        pane.add(labelGame2);

        labelGame3 = new JLabel("Trampa : Rojo");
        labelGame3.setSize(300,300);
        labelGame3.setLocation(650, 200);
        labelGame3.setFont(new Font("Girassol",Font.PLAIN,18));
        pane.add(labelGame3);

        imagJug1= new ImageIcon("src/Images_Datos/fichajugador.png");
        jug1 = new JLabel(imagJug1);
        jug1.setSize(30,30);
        jug1.setLocation(10,10);
        pane.add(jug1);

        imagJug2= new ImageIcon("src/Images_Datos/fichajugador1.png");
        jug2 = new JLabel(imagJug2);
        jug2.setSize(30,30);
        jug2.setLocation(10,40);
        pane.add(jug2);

        setResizable(false);
        pane.repaint();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dice) {
            Random diceR = new Random();
            dice_result = 1 + diceR.nextInt(4);
            labelDice.setText(String.valueOf(dice_result));
            Main.home.lista.elements.moveForward(dice_result, jugador);
            if (jugador==1){
                jugador++;
            } else {
                jugador--;
            }
        }else if (e.getSource() == back){
            Main.home.example.dispose();
            Main.home.setVisible(true);

        }
    }
}

class Home extends JFrame implements ActionListener{
    public JPanel pane;
    public JButton play;
    public JLabel player1;
    public JLabel player2;
    public JLabel title;
    public JTextField e_player1;
    public JTextField e_player2;
    public ImageIcon img;
    public ImageIcon imagTitle;
    public String s_player1;
    public String s_player2;
    public static Interface example;
    public static Lista lista;

    public Home() {
        setTitle("Math Challenge");
        setVisible(true);
        setSize(800, 700);
        pane = new JPanel();
        this.getContentPane().add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.decode("#bad5ff"));

        img = new ImageIcon("src/Images_Datos/reto.png");
        imagTitle = new ImageIcon("src/Images_Datos/MathTitle.png");

        play = new JButton("Jugar");
        play.setSize(200, 50);
        play.setLocation(300, 500);
        play.addActionListener(this);
        pane.add(play);

        player1 = new JLabel("Jugador Negro: ");
        player1.setSize(150, 40);
        player1.setLocation(250, 280);
        player1.setFont(new Font("Girassol", Font.PLAIN, 18));
        pane.add(player1);

        player2 = new JLabel("Jugador Naranja: ");
        player2.setSize(200, 40);
        player2.setLocation(250, 360);
        player2.setFont(new Font("Girassol", Font.PLAIN, 18));
        pane.add(player2);

        title = new JLabel( imagTitle);
        title.setSize(650, 210);
        title.setLocation(35, 5);
        pane.add(title);

        e_player1 = new JTextField(20);
        e_player1.setSize(150, 40);
        e_player1.setLocation(400, 280);
        pane.add(e_player1);

        e_player2 = new JTextField(20);
        e_player2.setSize(150, 40);
        e_player2.setLocation(400, 360);
        pane.add(e_player2);

        setResizable(false);
        pane.repaint();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {
            this.s_player1 = e_player1.getText();
            this.s_player2 = e_player2.getText();

            if (e_player1.getText().equals("") || e_player2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre en jugador");

            } else {
                e_player1.setText(null);
                e_player2.setText(null);

                example = new Interface();
                example.setVisible(true);
                lista = new Lista();
                lista.create();

                Main.home.setVisible(false);
            }
        } else {
        }
    }
}


