package com.project;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class servidor2 implements Runnable{
    static ServerSocket socketServer;
    static  Socket socketC;
//    public static void main(String[] args) {
//        try {
//            socketServer = new ServerSocket(9090);
//            System.out.println("Servidor Activo");
//            infoPack receivedPack;
//            socketC = socketServer.accept();
//            System.out.println("Cliente aceptado ");
//            while (true) {
//                ObjectInputStream inPack = new ObjectInputStream(socketC.getInputStream()); //respuesta de problema
//                receivedPack = (infoPack) inPack.readObject();
//                //Responde si respuesta en correcta o no
//                if (receivedPack.getCorrecto()==receivedPack.getRespuesta()){
//                    receivedPack.setAcierto(true);
//                }
//                else{
//                    receivedPack.setAcierto(false);
//                }
//                System.out.println("La respuesta es"+receivedPack.isAcierto());
////                Socket sendClient = new Socket("localhost", 9999);
//                ObjectOutputStream answerPack = new ObjectOutputStream(socketC.getOutputStream());
//                answerPack.writeObject(receivedPack);
////                sendClient.close();
//
//            }
//        } catch (Exception n) {
//            System.out.println(n.getMessage());
//        }
//    }


    //public static void start(){
//        try {
//            socketServer = new ServerSocket(9090);
//            System.out.println("Servidor Activo");
//            infoPack receivedPack;
//            socketC = socketServer.accept();
//            System.out.println("Cliente aceptado ");
//            while (true) {
//                ObjectInputStream inPack = new ObjectInputStream(socketC.getInputStream()); //respuesta de problema
//                receivedPack = (infoPack) inPack.readObject();
//                //Responde si respuesta en correcta o no
//                if (receivedPack.getCorrecto()==receivedPack.getRespuesta()){
//                    receivedPack.setAcierto(true);
//                }
//                else{
//                    receivedPack.setAcierto(false);
//                }
//                System.out.println("La respuesta es "+ receivedPack.isAcierto());
////                Socket sendClient = new Socket("localhost", 9999);
//                ObjectOutputStream answerPack = new ObjectOutputStream(socketC.getOutputStream());
//                answerPack.writeObject(receivedPack);
//                socketC.close();
//                socketServer.close();
////                sendClient.close();
//
//            }
//        } catch (Exception n) {
//            System.out.println(n.getMessage());
//        }
//    }

    @Override
    public void run() {
            try {
                socketServer = new ServerSocket(9090);
                System.out.println("Servidor Activo");
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
                    System.out.println("La respuesta es "+ receivedPack.isAcierto());
//                Socket sendClient = new Socket("localhost", 9999);
                    ObjectOutputStream answerPack = new ObjectOutputStream(socketC.getOutputStream());
                    answerPack.writeObject(receivedPack);
                    System.out.println("Cerrando servidor");
//                    socketC.close();
                    socketServer.close();
//                sendClient.close();

                }
            } catch (Exception n) {
                System.out.println(n.getMessage());
            }
        }
        }




