package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito...");

        Scanner scanner=new Scanner(System.in);

        Socket ss=new Socket("localhost",3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        DataOutputStream out = new DataOutputStream(ss.getOutputStream());

        String messaggio;
        String numero;
        do{
        System.out.println("indovina il numero");

        numero=scanner.nextLine();
        out.writeBytes(numero +"\n");

        messaggio=in.readLine();
        switch(messaggio){
            case ">":
            System.out.println("il numero e' troppo grande");
            out.writeBytes(messaggio+"\n");
            break;
            case "<":
            System.out.println("il numero e' troppo piccolo");
            out.writeBytes(messaggio+"\n");
            break;
            case "=":
            System.out.println("hai indovinato");
            out.writeBytes(messaggio+"\n");
            break;
            default:
            System.out.println("error");
            break;
        }
        if(messaggio.equals("=")){
            System.out.println("hai indovinato il numero");
            out.writeBytes(messaggio +"\n");
            ss.close();
        }else{

        }
        }while(!messaggio.equals("="));
    }
}