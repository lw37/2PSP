package es.florida;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class DronController {

    private static final int PORT_HTTP = 9876;
    public DronController (){

    }
    public Socket connect() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", PORT_HTTP));
        return socket;
    }

    public void takeOff(Socket socket ) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream), true);
        printer.println("TAKE-OFF");
        System.out.println("Taking off...");
    }

    public void land(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream), true);
        System.out.println("Landing");
    }

    public void firePrimaryCannon(Socket socket) throws  IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream), true);
        printer.println("FIRE_P_W");
        System.out.println("Ratatatatatatata!");

    }

    public void fireSecondaryWeapon(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream), true);
        printer.println("FIRE_P_W");
        System.out.println("Piñau! Piñau!");
    }

    public void shutDown(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream), true);
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        String secreto="OFF";
        String encriptado= encryptor.encrypt(secreto);
        printer.println(encriptado);
        System.out.println("Shutting down system...");
    }

}
