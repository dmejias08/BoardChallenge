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
    public static JLabel jug2;
    public static JLabel jug1;
    public int dice_result;
    public ImageIcon imagBack;

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
            Main.lista.elements.moveForward(dice_result, 1);
        }else if (e.getSource() == back){
            Main.home.setVisible(true);
            if (Main.example==null){
                System.out.println("Soy other y estoy vacio ");;
            }else {
                Main.example.setVisible(false);
            }
        }
//        try {
//            Thread.sleep(1000);
//            labelDice.setText("");
//    } catch (InterruptedException ex) {
//        ex.printStackTrace();
//        }
    }
}

class Home extends JFrame implements ActionListener{

    public JPanel pane;
    public JButton play;
    public JButton back;
    public JLabel player1;
    public JLabel player2;
    public JLabel title;
    public JTextField e_player1;
    public JTextField e_player2;
    public JLabel labelImg;
    public ImageIcon img;
    public ImageIcon imagBack;
    public ImageIcon imagTitle;
    public int play_result;
    public String divider = "/";
    public String s_player1;
    public String s_player2;

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
        play.setSize(400, 100);
        play.setLocation(200, 500);
        play.addActionListener(this);
        pane.add(play);



        player1 = new JLabel("Jugador Negro: ");
        player1.setSize(150, 40);
        player1.setLocation(200, 240);
        player1.setFont(new Font("Girassol", Font.PLAIN, 18));
        pane.add(player1);

        player2 = new JLabel("Jugador Naranja: ");
        player2.setSize(200, 40);
        player2.setLocation(200, 300);
        player2.setFont(new Font("Girassol", Font.PLAIN, 18));
        pane.add(player2);


        title = new JLabel( imagTitle);
        title.setSize(650, 210);
        title.setLocation(35, 5);
        pane.add(title);

        e_player1 = new JTextField(20);
        e_player1.setSize(150, 40);
        e_player1.setLocation(350, 240);
        pane.add(e_player1);

        e_player2 = new JTextField(20);
        e_player2.setSize(150, 40);
        e_player2.setLocation(350, 300);
        pane.add(e_player2);

//        labelImg = new JLabel(imagen);
//        labelImg.setSize(75, 75);
//        labelImg.setLocation(300, 100);
//        pane.add(labelImg);


//        public static JLabel setImage(ImageIcon image, int coord_x, int coord_y){
//            JLabel place = new JLabel(image);
//            place.setSize(75,75);
//            place.setLocation(coord_x,coord_y);
//            return place;

        setResizable(false);
        pane.repaint();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {
            this.s_player1 = e_player1.getText();
            this.s_player2 = e_player2.getText();

            if (s_player2 == "" || s_player2  == ""){
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre en jugador");

            }else {
//                this.s_player1 = e_player1.getText();
//                this.s_player2 = e_player2.getText();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                e_player1.setText(null);
                e_player2.setText(null);


                System.out.println("Jugador 1");
                System.out.println(s_player1);
                System.out.println("Jugador 2");
                System.out.println(s_player2);
//            if(this.other == null){
//                this.other = new Home();
//            }else{
//                this.other.setVisible(true);
//            }

                Main.example.setVisible(true);

                Main.home.setVisible(false);
            }

        }
    }
}


