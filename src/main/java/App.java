import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
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
}
