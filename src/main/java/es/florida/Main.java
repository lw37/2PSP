package es.florida;

import javax.swing.text.html.parser.Parser;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file =new File("numeros.txt");
        FileWriter writer=new FileWriter(file);
        PrintWriter printer=new PrintWriter(writer);
        long startTime=System.currentTimeMillis();
        for (int i=0;i<=100;i++){
            printer.println(Math.round((Math.random()*100+1)+0.5));
        }
        long endTime=System.currentTimeMillis();
        System.out.println("El proceso ha tartado: "+(endTime-startTime)+"ms");
        printer.close();

        FileReader reader=new FileReader(file);
        BufferedReader bReader=new BufferedReader(reader);
        String line;
        int num=0;
        while ((line=bReader.readLine())!=null){
            System.out.println(line);
            num+=Integer.parseInt(line);
        }
        System.out.println("El total es:"+num);
        bReader.close();

        System.out.println("El proceso ha tartado: "+(System.currentTimeMillis()-(endTime-startTime))+"ms");


    }
}
