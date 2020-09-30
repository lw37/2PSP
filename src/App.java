import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public void ae11() {
        System.out.println("Hola mundo");
    }

    public void Ae12a() {

        String[] nombre = new String[]{"Wei", "Jesus", "Miquel", "Adrian", "Manel", "Alex"};
        for (int i = 0; i < nombre.length; i++) {
            System.out.println(nombre[i]);
        }

    }

    public void Ae12b() {
        List<String> nombre = new ArrayList<>();

        nombre.add("Wei");
        nombre.add("Jesus");
        nombre.add("Miquel");
        nombre.add("Adrian");
        nombre.add("Alex");
        nombre.add("Manel");
        for (String i : nombre) {
            System.out.println(i);
        }
    }
    public int Ae13(int num) {

        int contator = 0;
        for (int i = 2; i < num; i++) {
            if (i % 2 == 0) {
                contator += i;
            }

        }
        return contator;
    }

    public void Ae14(){
        int factorial=1;
        for (int i = 1; i <= 15; i++) {
            factorial=factorial*i;
        }
        System.out.println(factorial);
    }
    public int Ae15(int[] listaNum){
        int mayor=0;
        for (int i = 0; i < listaNum.length; i++) {
            if(i>mayor){
                mayor=i;
            }
        }
        return mayor;
    }

    public void Ae16() {
        int nums[] = new int[5];
        Scanner reader = new Scanner(System.in);
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Escribe un nuemro:");
            nums[i] = reader.nextInt();
        }

        System.out.println("Mostrar en orden inverso.");
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println(nums[i]);
            total+=nums[i];
        }
        System.out.println("Suma de los numeros :"+total);
    }

    public void Ae17(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Escribe tu nombre:");
        String nombre=reader.next();
        System.out.print("Escribe tu años de experiencia :");
        int año= reader.nextInt();

        if (año<1){
            System.out.println(nombre+": Desarrollador Junior L1 – 15000-18000");
        }
        else if (año<=2){
            System.out.println(nombre+": Desarrollador Junior L2 – 18000-22000");
        }
        else if (año<=5){
            System.out.println(nombre+": Desarrollador Senior L2 – 28000-36000");
        }
        else if (año<=8){
            System.out.println(nombre+": Desarrollador Junior L1 – 15000-18000");
        }else {
            System.out.println(nombre+":Analista / Arquitecto. Salario a convenir en base a rol");
        }
    }


    public void Ae18() throws InterruptedException {
        long inicio = System.currentTimeMillis();

        Scanner reader = new Scanner(System.in);
        System.out.print("Escribe un numero inicial:");
        int n1=reader.nextInt();
        System.out.print("Escribe un numero final:");
        int n2=reader.nextInt();
        ArrayList<Integer> numeros =new ArrayList<>();
        for (int i = n1; i <= n2; i++) {
            if(esPrimo(i)){
                System.out.println(i+" es un numero primo");
            }else {
                System.out.println(i+" no es un numero primo");
            }
            numeros.add(i);
        }
        for (Integer i : numeros) {
            System.out.println(i);
        }
        long tiempo =  System.currentTimeMillis() - inicio;
        System.out.println("Duración: " + (tiempo)/1e6 + " ms");



    }
    public boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }
}
