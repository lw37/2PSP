import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class MenberMonitor {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("System started");
        MemberCreator memberCreator=new MemberCreator();
        MailSender mailSender= new MailSender(memberCreator);
        Increaser increaser=new Increaser(mailSender);
        Thread memberThread =new Thread(memberCreator);
        Thread increaserThread=new Thread(mailSender);
        Thread mailSenderThread1=new Thread(mailSender);

        memberThread.setPriority(Thread.MAX_PRIORITY);
        memberThread.start();
        increaserThread.start();

        mailSenderThread1.start();
        increaserThread.join();
        memberThread.join();
        mailSenderThread1.join();;

    }
}

