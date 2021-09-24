package com.project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static ServerSocket connector;
    public static ServerSocket connector2;
    private static int port = 9090;
    private static int port2 = 9999;
    public static Socket socket;
    public static Socket socket2;


    public static void main(String[] args) throws IOException {
        connector = new ServerSocket(port);
//        connector2 = new ServerSocket(port2);
        System.out.println("Server is waiting for connection...");
        socket = connector.accept();
//        socket2 = connector2.accept();
        System.out.println("Clientes conectado");

        Thread server = new Thread(new Server1());
//        Thread client = new Thread(new Client());

//        client.start();
        server.start();


    }
//    private static class Client implements Runnable  {
//
//        private  static BufferedReader keyboard;
//        private  static BufferedReader in;
//        private static PrintWriter out;
//
//
//
//        @Override
//        public void run() {
//            try{
//
//                // Send request to server
//                out = new PrintWriter(socket2.getOutputStream(),true);
//
//                // Get response
//                in = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
//
//                while (true) {
//                    if (frame.sendRequest) { // aqui va respues de reto
//                        String request = frame.pack;
//                        if (request.equals(null) == false){
//                            out.println(request);
//                            String response = in.readLine();
//
//                            frame.total.setText("Monto: "+ response);
//
//                        }
//
//                    }
//                    else{
//                        System.out.println("Disconnecting...");
//                        out.close();
//                        in.close();
//                        connector.close();
//                        socket2.close();
//                        break;
//                    }
//
//
//                }
//
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//
//
//        }
//    }

    private static class Server1 implements Runnable{
        private static ObjectInputStream in;
        private static ObjectOutputStream out;
        private static infoPack receivedPack;

        @Override
        public void run() {

            try {
                // Read from client
                in = new ObjectInputStream(socket.getInputStream()); //  price from client

                //Send response to  client
                out = new ObjectOutputStream(socket.getOutputStream()); // sent the total to server

                while (true) {
                    receivedPack = (infoPack) in.readObject();
                    System.out.println("Paquete recibido por servidor");

                    if (receivedPack.getCorrecto()==receivedPack.getRespuesta()){
                        receivedPack.setAcierto(true);
                    }
                    else{
                        receivedPack.setAcierto(false);
                    }
                    out.writeObject(receivedPack);
                }
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
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

