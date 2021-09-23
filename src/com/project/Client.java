//package com.project;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class Client {
//    public static final int port = 9090;
//    public static final int port2 = 9999;
//    public static Socket server;
//    public static Socket server2;
//
//    public static void main(String[] args) throws IOException {
//
//
//        server = new Socket("localhost",port);
//        server2 = new Socket("localhost",port2);
//
//        Thread client1 = new Thread(new Client1());
//        Thread server1 = new Thread(new Server2());
//
//        client1.start();
//        server1.start();
//
//
//
//    }
//
//
//    private static class Server2 implements Runnable{
//
//        private static BufferedReader in;
//        private static PrintWriter out;
//        private static String command_client;
//
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
//                    //if (frame1.sendRequest) {
//                        command_client = in.readLine();
//                       // out.println(getResponse());
//
//                    }
//                    else{
//                        System.out.println("Disconnecting...");
//                        in.close();
//                        out.close();
//                        server2.close();
//                        break;
//                    }
//
//                }
//
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//    }
//
//
//    private static class Client1 implements Runnable {
//        private static BufferedReader in;
//        private static PrintWriter out;
//        private static String response;
//
//        @Override
//        public void run() {
//            try {
//
//                //Response from server
//                in = new BufferedReader(new InputStreamReader(server.getInputStream())); //  price from server
//
//                //Request to server
//                out = new PrintWriter(server.getOutputStream(), true); // sent the total to server
//
//                while (true) {
//                    if (frame1.sendRequest) {
////                        System.out.println("ESTOY EN EL CICLO DE CIELNTE EN CLIENTE ");
//                        String request = frame1.pack;
////                        System.out.println("Hago pedido a Server1: "+request);
//                        if (request.equals(null) == false) {
//                            out.println(request);
//                            response = in.readLine(); // request servidor
////                            System.out.println("El monto :" + response);
//                            frame1.total.setText("Monto: " + response);
////                            frame1.pack = "0";
//                        }
//
//                    } else {
//                        System.out.println("Disconecting");
//                        server.close();
//                        in.close();
//                        out.close();
//                        break;
//                    }
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//    }
//}
