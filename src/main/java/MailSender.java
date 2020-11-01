import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MailSender implements Runnable{

    @Override
    public  void run() {

        try {
            LinkedList<String> fileStrings=read();
            for (String line : fileStrings) {
                System.out.println("Estimado "+line+", usuario "+fileStrings.getLast()+"ha unido a nuestro grupo.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized LinkedList<String> read() throws IOException {
        LinkedList<String> list=new LinkedList<>();
        FileReader reader=new FileReader("emailMembers.txt");
        BufferedReader bReader=new BufferedReader(reader);
        String line;
        while ((line=bReader.readLine())!=null){
            list.add(line);
        }
        bReader.close();
        return list;


    }
}

/*import java.util.LinkedList;

public class MailSender implements Runnable{

    private MemberCreator member;
    public MailSender(MemberCreator member){
        this.member=member;
    }
    @Override
    public  void run() {
        LinkedList<String> lista=member.Correos();
        for (String line : lista) {

            System.out.println("Estimado "+line+", usuario "+lista.getLast()+"ha unido a nuestro grupo.");
        }
    }
}
*/