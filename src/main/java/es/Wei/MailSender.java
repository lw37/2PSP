package es.Wei;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender implements Runnable {
    public static ExecutorService executorService= Executors.newFixedThreadPool(20);
    String lastUser;
    MailSender(String lastUser){
        this.lastUser=lastUser;
    }
    @Override
    public void run() {
        try {
            FileReader   reader = new FileReader("correos.txt");
            BufferedReader bReader = new BufferedReader(reader);
            String user;
            while (true) {
                try {
                    if (((user = bReader.readLine()) != null)) {
                        executorService.execute(new Enviar(user, lastUser));
                 }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
