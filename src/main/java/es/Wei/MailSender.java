package es.Wei;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

public class MailSender implements Runnable {
    String lastUser;

    MailSender(String lastUser) {
        this.lastUser = lastUser;
    }

    @Override
    public void run() {
        try {
            FileReader reader = new FileReader("correos.txt");
            BufferedReader bReader = new BufferedReader(reader);
            String user;
            Thread.sleep(1000);
            try {
                while(((user = bReader.readLine()) != null)) {
                    System.out.println(MessageFormat.format("Estimado usuario:{0} usario:{1} se ha unido a nuestro grupo.", user, lastUser));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
