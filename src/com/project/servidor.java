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
