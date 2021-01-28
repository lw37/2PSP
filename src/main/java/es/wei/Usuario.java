package es.wei;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Usuario {
    private static final int PORT_HTTP = 9876;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", PORT_HTTP));
        Thread ThreadComandos = new Thread(new Comandos(socket));
        ThreadComandos.start();
    }

    private static class Comandos implements Runnable {
        private Socket socket;

        public Comandos(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            OutputStream outputStream;
            try {
                outputStream = socket.getOutputStream();
                PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream), true);
                printer.println("TAKE-OFF");
                Thread.sleep(1000);
                printer.println("FIRE_P_W");
                Thread.sleep(1000);
                printer.println("FIRE_S_W");
                Thread.sleep(200);
                printer.println("LAND");
                printer.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
