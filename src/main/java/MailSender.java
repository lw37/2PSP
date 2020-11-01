import java.util.LinkedList;

public class MailSender implements Runnable{

    private final MemberCreator member;

    public MailSender(MemberCreator member){
        this.member=member;
    }

    @Override
    public  void run() {
        while (true){
            int longitud= this.member.Correo().size();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(longitud!=this.member.Correo().size()){
                this.member.Informar();
            }
        }
    }
}
