package es.Wei;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Aplicacion Started");
        Thread threadMemberCreator=new Thread(new MemberCreator());
        Thread threadMemberMonitor=new Thread(new MemberMonitor());
        threadMemberCreator.start();
        threadMemberMonitor.start();

    }
}
