package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class MioThread extends Thread{
    Socket s;
    public MioThread(Socket s){
  this.s=s;
    }
    public void run(){
        
           
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    DataOutputStream out = new DataOutputStream(s.getOutputStream());
                
                String numero;
                Random random =new Random();
                String messaggio;
                do{
                numero=in.readLine();
                int numeroDaIndovinare=random.nextInt(100);
                String indovina=Integer.toString(numeroDaIndovinare);
                int numeroControllo=Integer.parseInt(numero);
                if(indovina.equals(numero)){
                    messaggio="=";
                    out.writeBytes(messaggio +"\n");
                }
                else if(numeroDaIndovinare > numeroControllo){
                    messaggio="<";
                    out.writeBytes(messaggio +"\n");
                }
                
                else if(numeroDaIndovinare < numeroControllo){
                    messaggio=">";
                    out.writeBytes(messaggio +"\n");
                }
                
                
                }while(true);
            }catch (IOException e) {
                
                e.printStackTrace();
            }
                 
        
    }
}
