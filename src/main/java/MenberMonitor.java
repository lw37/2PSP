import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class MenberMonitor {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("System started");
        MemberCreator memberCreator=new MemberCreator();
        Thread memberThread =new Thread(memberCreator);

        MailSender mailSender= new MailSender();
        Thread mailSenderThread1=new Thread(mailSender);
        ///Thread mailSenderThread2=new Thread(mailSender);
        ///Thread mailSenderThread3=new Thread(mailSender);
        memberThread.start();
        memberThread.join();
        mailSenderThread1.start();
        mailSenderThread1.join();;

    }

}

