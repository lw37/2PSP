import java.text.MessageFormat;

import static sun.misc.MessageUtils.out;

public class Enviar implements Runnable {
    String user;
    String lastUser[];
    public Enviar(String user, String[] args) {
        this.user=user;
        this.lastUser=args;
    }

    @Override
    public void run() {

        out(MessageFormat.format("Estimado usuario:{0} usario:{1} se ha unido a nuestro grupo.", user, lastUser));
    }
}
