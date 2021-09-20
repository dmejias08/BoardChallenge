package com.project;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor{
    public static void main(String[] args) {
        try {
            ServerSocket socketServer = new ServerSocket(9090);
            System.out.println("Servidor Activo");
            infoPack receivedPack;
            while (true) {
                Socket socketC = socketServer.accept();
                ObjectInputStream inPack = new ObjectInputStream(socketC.getInputStream());
                receivedPack = (infoPack) inPack.readObject();
                if (receivedPack.getCorrecto()==receivedPack.getRespuesta()){
                    receivedPack.setAcierto(true);
                }
                else{
                    receivedPack.setAcierto(false);
                }
                System.out.println(receivedPack.isAcierto());
                Socket sendClient = new Socket("localhost", 9999);
                ObjectOutputStream answerPack = new ObjectOutputStream(sendClient.getOutputStream());
                answerPack.writeObject(receivedPack);
                sendClient.close();
                socketC.close();
            }
        } catch (Exception n) {
            System.out.println(n.getMessage());
        }
    }
}

class infoPack implements Serializable {
    private double correcto, respuesta;
    private boolean acierto;

    public boolean isAcierto() {
        return acierto;
    }

    public void setAcierto(boolean acierto) {
        this.acierto = acierto;
    }

    public double getCorrecto() {
        return correcto;
    }

    public void setCorrecto(double correcto) {
        this.correcto = correcto;
    }

    public double getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(double respuesta) {
        this.respuesta = respuesta;
    }
}
