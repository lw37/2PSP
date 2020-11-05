import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MailSender implements Runnable{

    private final MemberCreator member;
    private int longitud;
    public MailSender(MemberCreator member){
        this.member=member;
    }
    Lock lock=new ReentrantLock();
    @Override
    public  void run() {
        System.out.println("MailSender Started");
        while (true){
             longitud= this.member.Correo().size();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            for (int i = 0; i < this.member.Correo().size() ; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(longitud!=this.member.Correo().size()){
                    this.member.Informar(i);
                }
            }
            lock.unlock();
        }
    }

}
