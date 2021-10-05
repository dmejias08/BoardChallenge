package com.project;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class servidor2 implements Runnable{
    static ServerSocket socketServer;
    static  Socket socketC;

    @Override
    public void run() {
            try {
                socketServer = new ServerSocket(9090);
                infoPack receivedPack;
                socketC = socketServer.accept();
                System.out.println("Cliente aceptado ");
                while (true) {
                    ObjectInputStream inPack = new ObjectInputStream(socketC.getInputStream()); //respuesta de problema
                    receivedPack = (infoPack) inPack.readObject();
                    //Responde si respuesta en correcta o no
                    if (receivedPack.getCorrecto()==receivedPack.getRespuesta()){
                        receivedPack.setAcierto(true);
                    }
                    else{
                        receivedPack.setAcierto(false);
                    }
                    ObjectOutputStream answerPack = new ObjectOutputStream(socketC.getOutputStream());
                    answerPack.writeObject(receivedPack);
                    socketServer.close();
                }
            } catch (Exception n) {
                n.getMessage();
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




