package es.Wei;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MemberCreator implements Runnable {
    @Override
    public void run() {
        System.out.println("Creator Started");
        File file = new File("correos.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        PrintWriter printer = new PrintWriter(writer);
        while (true) {
            i++;
            printer.println(i + "@qq.com");
            printer.flush();
            System.out.println("Creado user: " + i + "@qq.com");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
