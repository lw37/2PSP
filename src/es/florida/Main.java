package es.florida;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {
    public static final int PROT_HTTP=9876;
    public static void main(String[] args) throws IOException {
        Socket socket= new Socket();
        socket.connect(new InetSocketAddress("51.254.113.216",PROT_HTTP));
        InputStream  inputStream=socket.getInputStream();
        OutputStream outputStream=socket.getOutputStream();
        BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter printer=new PrintWriter(new OutputStreamWriter(outputStream),true);
        printer.println("HELP");

        String line;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }
}
