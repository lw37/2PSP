import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MailSender {

    public static void main(String[] args) throws IOException {
        System.out.println("MAILSENDER START");
        System.out.println(args + "MAILSENDER RUN");
        FileReader reader = new FileReader("correos.txt");
        BufferedReader bReader = new BufferedReader(reader);
        String user;
        while ((user = bReader.readLine()) != null) {
            Thread envioThread=new Thread(new Enviar(user,args));
        }


    }
}
