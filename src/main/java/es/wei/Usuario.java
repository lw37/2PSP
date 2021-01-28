package es.wei;

import es.florida.DronController;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Usuario {


    public static void main(String[] args) throws IOException, InterruptedException {
       DronController dronController=new DronController();
       Socket usuario= dronController.connect();
        dronController.takeOff(usuario);
        Thread.sleep(1000);
        dronController.firePrimaryCannon(usuario);
        Thread.sleep(1000);
        dronController.fireSecondaryWeapon(usuario);
        dronController.land(usuario);
    }



}
