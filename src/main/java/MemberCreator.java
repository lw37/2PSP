import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class MemberCreator implements Runnable {
    String fileName="emailMembers.txt";

    @Override
    public void run() {
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void start() throws IOException, InterruptedException {

            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            PrintWriter printer = new PrintWriter(writer);

            int correos = 10000;

            for (int i = 0; i < 100; i++)
             {
                correos++;
                printer.println(correos + "@qq.com");

            }
            printer.close();

        }


    }


/*import java.util.LinkedList;

public class MemberCreator implements Runnable {
    private static LinkedList<String> correos=new LinkedList<String>();
    private int num=1;
    @Override
    public synchronized void run() {


            for (int i = 0; i < 3; i++) {

                correos.add(i+"@qq.com");
            }


        }

    public  LinkedList<String> Correos(){
        return correos;
    }



}
*/