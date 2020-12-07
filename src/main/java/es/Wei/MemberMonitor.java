package es.Wei;
import java.io.*;
public class MemberMonitor implements Runnable{
    @Override
    public void run() {
        System.out.println("Monitor Started");
        FileReader reader = null;
        try {
            reader = new FileReader("correos.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
                    Thread mailSenderThread = new Thread(new MailSender(user));
                    mailSenderThread.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
