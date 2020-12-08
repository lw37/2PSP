package es.Wei;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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
    public synchronized void run() {
        try {
            FileReader reader = new FileReader("correos.txt");
            BufferedReader bReader = new BufferedReader(reader);
            String user;
            Thread.sleep(1000);
            try {
                while (((user = bReader.readLine()) != null)) {
                    Email email = new SimpleEmail();
                    email.setHostName("localhost");
                    email.setSmtpPort(1025);
                    email.setFrom(user);
                    email.setSubject("Nuevo usuario añadido");
                    email.setMsg(MessageFormat.format("Estimado usuario:{0} usuario:{1} se ha unido a nuestro grupo.", user, lastUser));
                    email.addTo(lastUser);
                    email.send();
                    System.out.println(MessageFormat.format("Estimado usuario:{0} usario:{1} se ha unido a nuestro grupo.", user, lastUser));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (EmailException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
