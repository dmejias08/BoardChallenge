package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static Interface example;
    public static Home home;
    public static Reto reto;
    public static Lista lista;
    public static String divider = "/";

    public static void main(String[] args) {

        home = new Home();
        example = new Interface();
        example.setVisible(false);
        //example = new Interface();
        lista = new Lista();
        lista.create();
        home.repaint();

        //example.repaint();

    }
}


