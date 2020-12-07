package es.Wei;

import java.text.MessageFormat;

public class Enviar implements Runnable {
    String user,lastUser;
    public Enviar(String user, String lastUser) {
        this.lastUser=lastUser;
        this.user=user;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(MessageFormat.format("Estimado usuario:{0} usario:{1} se ha unido a nuestro grupo.", user, lastUser));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
