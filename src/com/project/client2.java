package com.project;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class client2 {
    public boolean acierto;

    public boolean isAcierto() {
        return acierto;
    }

    public void setAcierto(boolean acierto) {
        this.acierto = acierto;
    }

    public static Socket socketClientReceiver;

    public void start() {
        try {
            infoPack receivedPack;
            while (true) {
                ObjectInputStream inPack = new ObjectInputStream(socketClientReceiver.getInputStream());
                receivedPack = (infoPack) inPack.readObject();
                acierto = receivedPack.isAcierto();
                String respuesta;
                if (acierto){
                    respuesta="correcta";
                } else {
                    respuesta="incorrecta";
                }
                JOptionPane.showMessageDialog(null,"Su respuesta fue: "+respuesta);
                socketClientReceiver.close();
            }
        } catch (Exception n) {
            n.getMessage();
        }
    }

    public void send(double correcto, double respuesta){
        try{
            socketClientReceiver = new Socket("localhost",9090);
            infoPack data = new infoPack();
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
