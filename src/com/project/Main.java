package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static Interface example;
    public static Reto reto;
    public static  Lista lista;
    public static String divider = "/";

    public static void main(String[] args) {
	 example = new Interface();
	 lista = new Lista();
	 lista.create();
	 example.repaint();
    }
}


