package com.project;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class client2 {
    private static boolean acierto;

    public boolean isAcierto() {
        return acierto;
    }

    public void setAcierto(boolean acierto) {
        this.acierto = acierto;
    }

    public static Socket socketClientReceiver;

    public static void start() {
        try {
            infoPack receivedPack;
            while (true) {
                ObjectInputStream inPack = new ObjectInputStream(socketClientReceiver.getInputStream());
                receivedPack = (infoPack) inPack.readObject();
                acierto = receivedPack.isAcierto();
                System.out.println("Mi respuesta fue "+acierto);
                JOptionPane.showMessageDialog(null,"Su respuesta fue: "+acierto);
                System.out.println("Cerrando cliente");
                socketClientReceiver.close();
            }
        } catch (Exception n) {
            System.out.println(n.getMessage());
        }
    }

    public static void send(double correcto, double respuesta){
        try{
            socketClientReceiver = new Socket("localhost",9090);
            infoPack data = new infoPack();
            data.setAcierto(false);
            data.setCorrecto(correcto);
            data.setRespuesta(respuesta);
            ObjectOutputStream outPack = new ObjectOutputStream(socketClientReceiver.getOutputStream());
            outPack.writeObject(data);
            System.out.println("Enviado");
        } catch (Exception n) {
            n.getMessage();
        }
    }
}
