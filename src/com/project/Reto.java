package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Reto extends JFrame implements ActionListener {
    ImageIcon imageClass;
    JLabel place;
    JPanel juego;
    JPanel msgBox;
    JLabel challenge;
    JTextField answer;
    JButton ask;
    public int x, y;
    public double retoNum, res;
    String reto = "";
    public boolean notUsed = true;

    public void set() {

        imageClass = new ImageIcon("src" + Main.divider + "Images_Datos" + Main.divider + "reton.png");
        place = new JLabel(imageClass);
        place.setText("Reto");
        place.setSize(75, 75);
        place.setLocation(x, y);
        juego.add(place);
        juego.repaint();
    }

    public void start() {
        Random rand = new Random();
        int a, b, op;
        op = rand.nextInt(5 - 1) + 1;
        a = rand.nextInt(51 - 1) + 1;
        b = rand.nextInt(51 - 1) + 1;

        setTitle("Reto");
        setVisible(true);
        setSize(300, 200);
        msgBox = new JPanel();
        this.getContentPane().add(msgBox);
        msgBox.setLayout(null);
        msgBox.setBackground(Color.decode("#bad5ff"));
        setResizable(false);
        msgBox.repaint();

        if (op == 1) {
            this.reto = a + "+" + b;
            this.retoNum = a + b;
        }
        if (op == 2) {
            this.reto = a + "-" + b;
            this.retoNum = a - b;
        }
        if (op == 3) {
            double an, bn;
            an = (a*100.0)/100.0;
            bn = (b*100.0)/100.0;
            this.reto = a + "/" + b;
            this.retoNum = an/bn;
        }
        if (op == 4) {
            this.reto = a + "*" + b;
            this.retoNum = a * b;
        }

        if (notUsed) {
            challenge = new JLabel("¿Cuál es el valor de " + this.reto + "?");
            challenge.setSize(200, 20);
            challenge.setLocation(60, 30);
            msgBox.add(challenge);

            answer = new JTextField();
            answer.setSize(50, 20);
            answer.setLocation(115, 70);
            msgBox.add(answer);

            ask = new JButton("Ok");
            ask.setSize(50, 20);
            ask.setLocation(115, 110);
            msgBox.add(ask);
            ask.addActionListener(this::actionPerformed);
            this.notUsed = false;
            msgBox.repaint();

        } else {
            answer.setText(null);
            challenge.setText("¿Cuál es el valor de " + this.reto + "?");
            msgBox.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ask) {
            try {
                res = Double.parseDouble(answer.getText());
                servidor2 server1 = new servidor2();
                client2 client2 = new client2();
                Thread server = new Thread(server1);
                server.start();
                client2.send(retoNum, res);
                client2.start();
                if (client2.acierto == false) {
                    if (Main.home.lista.elements.jugadorActual == 1 && Main.home.lista.elements.jugador2 != null) {
                        Main.home.lista.elements.moveTuTr(1, 2, false);
                    } else if (Main.home.lista.elements.jugadorActual == 2 && Main.home.lista.elements.jugador1 != null) {
                        Main.home.lista.elements.moveTuTr(1, 1, false);
                    }
                }
                Main.home.lista.elements.moveTuTr(1, Main.home.lista.elements.jugadorActual, true);
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Sólo se permite la entrada de enteros");
                answer.setText(null);
            }
            Main.home.example.dice.setEnabled(true);
            this.dispose();
        }
    }
}
