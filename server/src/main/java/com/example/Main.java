package com.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws java.io.IOException{
        System.out.println("server partito...");
        ServerSocket s=new ServerSocket();
        do{
            Socket ss=new Socket();
            MioThread t=new MioThread(ss);
            t.start();
        }while(true);
       
    }
}