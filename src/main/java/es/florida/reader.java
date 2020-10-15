package es.florida;

import javax.swing.text.html.parser.Parser;
import java.io.*;

public class reader {
    public static void main(String[] args) throws IOException {
        FileReader reader=new FileReader("numeros.txt");
        BufferedReader bReader=new BufferedReader(reader);
        String line;
        long startTime=System.currentTimeMillis();
        int num=0;
        while ((line=bReader.readLine())!=null){
            System.out.println(line);
            num+=Integer.parseInt(line);
        }
        System.out.println("El total es:"+num);
        bReader.close();

        System.out.println("El proceso ha tartado: "+(System.currentTimeMillis()-startTime)+"ms");

    }

}
