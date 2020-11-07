import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {

        System.out.println("Aplicacion Started");
        Thread monitorLauncherThread = new Thread(new MonitorLauncher());
        Thread ceatorLauncherThread = new Thread(new CreatorLauncher());
        monitorLauncherThread.start();
        ceatorLauncherThread.start();

    }
    private static void MemberCreatorStart() throws IOException {
        ProcessBuilder builder=new ProcessBuilder("java","-cp","C:\\Users\\luolu\\IdeaProjects\\2PSP\\out\\production\\2PSP","MemberCreator");
        Process lsProcess =builder.start();
        InputStream processOut=lsProcess.getInputStream();
        InputStreamReader isr=new InputStreamReader(processOut);
        BufferedReader bis=new BufferedReader(isr);

        String line;
        while ((line=bis.readLine())!=null){
            System.out.println(line);
        }
    }

    private static void MemberMonitorStart() throws IOException {
        ProcessBuilder builder=new ProcessBuilder("java","-cp","C:\\Users\\luolu\\IdeaProjects\\2PSP\\out\\production\\2PSP","MemberMonitor");
        Process lsProcess =builder.start();
        InputStream processOut=lsProcess.getInputStream();
        InputStreamReader isr=new InputStreamReader(processOut);
        BufferedReader bis=new BufferedReader(isr);
        String line;
        while ((line=bis.readLine())!=null){
            System.out.println(line);
        }
    }

    private static class MonitorLauncher implements Runnable {

        @Override
        public void run() {
            try {
                MemberMonitorStart();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static class CreatorLauncher implements Runnable {

        @Override
        public void run() {
            try {
                MemberCreatorStart();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

       /* ProcessBuilder builder=new ProcessBuilder("java","-cp","C:\\Users\\luolu\\IdeaProjects\\2PSP\\out\\production\\2PSP","MenberMonitor");
        Process lsProcess =builder.start();
        InputStream processOut=lsProcess.getInputStream();
        InputStreamReader isr=new InputStreamReader(processOut);
        BufferedReader bis=new BufferedReader(isr);

        String line;
        while ((line=bis.readLine())!=null){
            System.out.println(line);
        }
*/