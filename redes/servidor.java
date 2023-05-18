import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class servidor
{
    static final int PUERTO=54321;
    private boolean bandera = true;
    
    public servidor (){
        try{
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println ("Escucho puerto: " + PUERTO);
            
            for (int numCli = 0; numCli < 3; numCli++){
                Socket skCliente = skServidor.accept ();
                System.out.println("Sirvo al cliente "+ numCli);
                DataInputStream in = new DataInputStream(skCliente.getInputStream());
                DataOutputStream out = new DataOutputStream(skCliente.getOutputStream());
                
                while (bandera){
                    String x = in.readUTF();
                    if(x.equals("bye")){
                        out.writeUTF ("bye");
                    //System.out.println("El resultado es "+ result);
                        skCliente.close();
                        bandera = false;
                    }
                    System.out.println("Recibi tu mensaje "+ x);
                    
                    Scanner param = new Scanner(System.in);
                    
                        
                        System.out.println("Ingresa tu mensaje para Melvi");
                        String y = param.nextLine();
            
        
                        
                        out.writeUTF (y);
        
                        if(y.equals("bye")){
                            bandera = false;
                            skCliente.close();
                        }
                    
                    
                    
                }
                
                
            }
            System.out.println("Demasiados clientes por hoy");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] arg){
        new servidor();
    }
}
