import java.io.*;
import java.util.Scanner;
import java.net.*;
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente
{
    static final int PUERTO=54321;
    static final String HOST="localhost";
    private boolean bandera = true;
    
    public Cliente (){
        try{
            Socket skCliente = new Socket(HOST, PUERTO);
            
            DataInputStream in = new DataInputStream(skCliente.getInputStream());
            DataOutputStream out = new DataOutputStream(skCliente.getOutputStream());
            
            Scanner param = new Scanner(System.in);
            
            while(bandera){
                System.out.println("Ingresa tu mensaje para Johel");
                String x = param.nextLine();
                out.writeUTF (x);
                if(x.equals("bye")){
                    bandera = false;
                    skCliente.close();
                }
                
                String y = in.readUTF();
                System.out.println("Recibi tu mensaje "+ y);
            }
            //String result = in.readUTF();
            
            
            //System.out.println("El resultado es: "+ result);
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] arg){
        new Cliente();
    }
}
