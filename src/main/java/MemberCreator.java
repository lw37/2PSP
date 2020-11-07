import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class MemberCreator {
    public static void main(String[] args) {
        System.out.println("Creator Started");
        File file = new File("correos.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printer = new PrintWriter(writer);
        for (int i = 1; i < 1000000000; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printer.println(i+"@qq.com");
            printer.flush();
            System.out.println("Creado user: "+i+"@qq.com");
        }
    }
    }

    /*    private  LinkedList<String> correos=new LinkedList<String>();
    Lock lock=new ReentrantLock();
    @Override
    public synchronized void run() {
        System.out.println("MemberCreator Started");
        File file = new File("correos.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printer = new PrintWriter(writer);
        for (int i = 1; i < 1000000000; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printer.println(i+"@qq.com");
            printer.flush();
            correos.add(i+"@qq.com");
            System.out.println("Creado user: "+i+"@qq.com");
        }

    }

    public LinkedList<String> Correo(){
        return correos;
    }



    public void Informar(int num){
        lock.lock();
        System.out.println("Estimado "+correos.get(num)+", usuario "+correos.getLast()+" ha unido a nuestro grupo.");
        lock.unlock();
    }*/
