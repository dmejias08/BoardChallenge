package com.project;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class cliente {
    private boolean acierto;

    public boolean isAcierto() {
        return acierto;
    }

    public void setAcierto(boolean acierto) {
        this.acierto = acierto;
    }

    public void start() {
        try {
            Socket socketClientReceiver = new Socket("localhost", 9999);
            infoPack receivedPack;
            while (true) {
                ObjectInputStream inPack = new ObjectInputStream(socketClientReceiver.getInputStream());
                receivedPack = (infoPack) inPack.readObject();
                acierto = receivedPack.isAcierto();
                socketClientReceiver.close();
            }
        } catch (Exception n) {
            System.out.println(n.getMessage());
        }
    }

    public void send(double correcto, double respuesta){
        try{
            Socket socketClientSend = new Socket("localhost", 9090);
            infoPack data = new infoPack();
            data.setAcierto(false);
            data.setCorrecto(correcto);
            data.setRespuesta(respuesta);
            ObjectOutputStream outPack = new ObjectOutputStream(socketClientSend.getOutputStream());
            outPack.writeObject(data);
            System.out.println("Enviado");
            socketClientSend.close();
        } catch (Exception n) {
            n.getMessage();
        }
    }
}
