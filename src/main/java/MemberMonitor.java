import java.io.*;
import java.util.ArrayList;

public class MemberMonitor {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Monitor Started");
        while(true){
            FileReader reader = new FileReader("correos.txt");
            BufferedReader bReader = new BufferedReader(reader);
            ArrayList<String> lista= new ArrayList<>();
            String user;
            while ((user = bReader.readLine()) != null) {
                lista.add(user);
            }
            int length=lista.size();

            Thread.sleep(3000);

            FileReader reader1 = new FileReader("correos.txt");
            BufferedReader bReader1 = new BufferedReader(reader1);
            ArrayList<String> lista1= new ArrayList<>();
            String user1;
            while ((user1 = bReader1.readLine()) != null) {
                lista1.add(user1);
            }
            int length1=lista1.size();

            if (length1>length){
                Thread mailSenderThread = new Thread(new MailSenderLauncher(user1));
                mailSenderThread.start();
                mailSenderThread.join();
            }
        }
    }


    private static  void MailSenderStart(String lastUser) throws IOException {
        System.out.println("MailSenderStart run");
        ProcessBuilder builder = new ProcessBuilder("java", "-cp", "C:\\Users\\luolu\\IdeaProjects\\2PSP\\out\\production\\2PSP", "MailSender",lastUser);
        Process lsProcess = builder.start();
        InputStream processOut = lsProcess.getInputStream();
        InputStreamReader isr = new InputStreamReader(processOut);
        BufferedReader bis = new BufferedReader(isr);
        String line;
        while ((line = bis.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("MailSenderStart run1");
    }

    private static class MailSenderLauncher implements Runnable {
        private String lastUser;
        public MailSenderLauncher(String lastUser){
            this.lastUser=lastUser;
        }

        @Override
        public synchronized void run() {
            try {
                System.out.println("MailSenderLauncher run");
                MailSenderStart(lastUser);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}





