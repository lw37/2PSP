package es.Wei;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemberMonitor implements Runnable{
    public static ExecutorService executorService= Executors.newFixedThreadPool(19);
    @Override
    public void run() {
        System.out.println("Monitor Started");
        try {
            FileReader  reader = new FileReader("correos.txt");
            BufferedReader bReader = new BufferedReader(reader);
            String user;
            while (true) {
                try {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user = bReader.readLine();
                    if (user != null) {
                        executorService.execute(new MailSender(user));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
