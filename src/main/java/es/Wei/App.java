package es.Wei;

public class App {
    public static void main(String[] args) {
        System.out.println("Aplicacion Started");
        Thread threadMemberCreator = new Thread(new MemberCreator());
        Thread threadMemberMonitor = new Thread(new MemberMonitor());
        threadMemberCreator.start();
        threadMemberMonitor.start();
    }
}
