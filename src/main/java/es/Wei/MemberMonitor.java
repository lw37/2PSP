package es.Wei;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemberMonitor implements Runnable {
    public static ExecutorService executorService = Executors.newFixedThreadPool(19);

    @Override
    public void run() {
        System.out.println("Monitor Started");
        FileReader reader = null;
        try {
            reader = new FileReader("correos.txt");
            BufferedReader bReader1 = new BufferedReader(reader);
            while (true) {
                try {
                    String user;
                    user = bReader1.readLine();
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

