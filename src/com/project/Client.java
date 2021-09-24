package com.project;

import java.io.*;
import java.net.Socket;

public class Client {
    public static final int port = 9090;
    public static final int port2 = 9999;
    public static Socket server;
    public static Socket server2;

    public static void main(String[] args) throws IOException {
        server = new Socket("localhost",port);
//        server2 = new Socket("localhost",port2);

        Thread client1 = new Thread(new Client1());
//        Thread server1 = new Thread(new Server2());

        client1.start();
//        server1.start();
    }


//    private static class Server2 implements Runnable{
//
//        private static BufferedReader in;
//        private static PrintWriter out;
//        private static String command_client;
//
//        @Override
//        public void run() {
//
//            try {
//                // Read from client
//                in = new BufferedReader(new InputStreamReader(server2.getInputStream())); //  price from client
//
//                //Send response to  client
//                out = new PrintWriter(server2.getOutputStream(), true); // sent the total to server
//
//                while (true) {
//                    if (frame1.sendRequest) {
//                        command_client = in.readLine();
//                        out.println(getResponse());
//
//                    } else {
//                        System.out.println("Disconnecting...");
//                        in.close();
//                        out.close();
//                        server2.close();
//                        break;
//                    }
//
//                }
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    private static class Client1 implements Runnable {
        private static ObjectInputStream in;
        private static ObjectOutputStream out;
        private static infoPack data;
        private static infoPack receivedPack;
        private boolean response;

        @Override
        public void run() {
            try {
                //Send response to  server
                System.out.println("Estoy en cliente cliente antes de out");
                out = new ObjectOutputStream(server.getOutputStream()); // sent the total to server

                // Read from server
                System.out.println("Estoy en cliente cliente antes de in");
                in = new ObjectInputStream(server.getInputStream()); //  price from client

                while (true) {
                    try{
                        System.out.println("Antes de retoActive");
                        System.out.println(Main.lista.elements.retoActive);
                        if (Main.lista.elements.retoActive) {
                            System.out.println("Estoy en cliente cliente");
                            data = Main.lista.elements.retoActual;
                            out.writeObject(data);
                            receivedPack = (infoPack) in.readObject();
                            response = receivedPack.isAcierto();
                            int jugador = Main.lista.elements.jugadorActual;
                            System.out.println(response);
                            if (response == false) {
                                if (jugador == 1 && Main.lista.elements.jugador1.next != null) {
                                    Main.lista.elements.moveTuTr(1, 2, false);
                                } else if (jugador == 2 && Main.lista.elements.jugador2.next != null) {
                                    Main.lista.elements.moveTuTr(1, 1, false);
                                }
                                Main.lista.elements.moveTuTr(1, jugador, true);
                            }
                            Main.lista.elements.retoActive = false;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
