/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmclaves;
import java.util.Scanner;
import java.io.Console;
/**
 *
 * @author Desarrollo
 */
public class Validador {
    Scanner s;
    String Passwd ;
    int contador = 0;
    int contador2 = 0; 
    //Console console ;
    
    public Validador(){
        s = new Scanner(System.in);
        //console = System.console();
        
      
    }
    
    public void ValidadorClave(){
        Conector conector = new Conector();
        
        System.out.print("Ingrese Contraseña: ");
        Passwd = s.nextLine();
        //console.readPassword("Contraseña");

        if (conector.getTablauserPassword(Passwd) == true) {
            System.out.println("Bienvenido");
            
        }
        else {
            System.out.println("Clave Incorrecta");
            do{
                
                if (conector.getTablauserPassword(Passwd) == false) {
                System.out.print("Ingrese Contraseña: ");
                Passwd = s.nextLine();
                contador = contador +1 ;
                   if(contador >=3){
                       System.out.println("Se ha Enviado un correo de Notifacion Intento Ingresar mas de " + " " + contador + " Veces");
                   }
                }
                      
        }while (conector.getTablauserPassword(Passwd) != true);
           
        }
        System.out.println("Bienvenido");
        
        
        
    }
              
       
}

    
    
    

