package es.wei;

import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {
    private static final int PORT_HTTP = 6789;
    public static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT_HTTP);
        Socket usuario;
        while (true) {
            usuario = server.accept();
            executorService.execute(new Trabajador(usuario));
        }
    }

    private static class Trabajador implements Runnable {
        private Socket usuario;

        public Trabajador(Socket usuario) {
            this.usuario = usuario;
        }

        public void run() {
            try {
                OutputStream outputStream = usuario.getOutputStream();
                InputStream input = usuario.getInputStream();
                BufferedReader bReader = new BufferedReader(new InputStreamReader(input));
                PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream), true);
                String recibido;
                printer.println("Has venido al servidor");
                recibido = bReader.readLine();
                printer.println("Recibido comando correctamente  :" + recibido);
                System.out.println("Recibido comando correctamente  :" + recibido);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
