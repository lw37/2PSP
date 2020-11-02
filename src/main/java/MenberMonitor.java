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
        Thread memberThread =new Thread(memberCreator);
        Thread mailSenderThread1=new Thread(mailSender);

        memberThread.setPriority(Thread.MIN_PRIORITY);
        memberThread.start();
        mailSenderThread1.start();
        memberThread.join();
        mailSenderThread1.join();;

    }
}

