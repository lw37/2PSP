import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MemberCreator implements Runnable {
    private  LinkedList<String> correos=new LinkedList<String>();
    Lock lock=new ReentrantLock();

    @Override
    public synchronized void run() {
        System.out.println("MemberCreator Started");

        for (int i = 1; i < 100; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            correos.add(i+"@qq.com");
            System.out.println("Creado user: "+i+"@qq.com");
        }


    }

    public LinkedList<String> Correo(){
        return correos;
    }

    public void Informar(){
        for (String line : correos) {
            System.out.println("Estimado "+line+", usuario "+correos.getLast()+"ha unido a nuestro grupo.");
        }
    }




}
