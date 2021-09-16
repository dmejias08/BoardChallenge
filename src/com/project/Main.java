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


