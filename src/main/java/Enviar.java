import java.text.MessageFormat;

public class Enviar implements Runnable {
    String user;
    String lastUser;
    public Enviar(String user, String lastUser) {
        this.user=user;
        this.lastUser=lastUser;
    }

    @Override
    public void run() {

        System.out.println(MessageFormat.format("Estimado usuario:{0} usario:{1} se ha unido a nuestro grupo.", user, lastUser));
    }
}
