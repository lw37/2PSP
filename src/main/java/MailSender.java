import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MailSender {

    public static void main(String[] args) throws IOException {
        System.out.println("MAILSENDER START");
        System.out.println(args[0] + "MAILSENDER RUN");
        String lastUser=args[0];
        FileReader reader = new FileReader("correos.txt");
        BufferedReader bReader = new BufferedReader(reader);
        String user;
        while ((user = bReader.readLine()) != null) {
            Thread envioThread=new Thread(new Enviar(user,lastUser));
            envioThread.start();
        }


    }
}
