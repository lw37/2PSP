import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class MemberMonitor {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Monitor Started");
        FileReader reader = new FileReader("correos.txt");
        BufferedReader bReader = new BufferedReader(reader);
        String user;
        while ((user = bReader.readLine()) != null) {
                System.out.println("leer"+(user));
                Thread mailSenderThread = new Thread(new MailSenderLauncher(user));
                mailSenderThread.start();
        }


    }


    private static void MailSenderStart(String lastUser) throws IOException {
        System.out.println("MailSenderStart run");
        ProcessBuilder builder = new ProcessBuilder("java", "-cp", "C:\\Users\\luolu\\IdeaProjects\\2PSP\\out\\production\\2PSP", "MailSender");
        Process lsProcess = builder.start();
        InputStream processOut = lsProcess.getInputStream();
        InputStreamReader isr = new InputStreamReader(processOut);
        BufferedReader bis = new BufferedReader(isr);
        String line;
        while ((line = bis.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static class MailSenderLauncher implements Runnable {
        private String lastUser;
        public MailSenderLauncher(String lastUser){
            this.lastUser=lastUser;
        }

        @Override
        public void run() {
            try {
                System.out.println("MailSenderLauncher run");
                MailSenderStart(lastUser);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}





