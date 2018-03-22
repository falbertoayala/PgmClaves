/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmclaves;
import java.util.Scanner;
/**
 *
 * @author Desarrollo
 */
public class Validador {
    Scanner s;
    String Passwd ;
    public Validador(){
        s = new Scanner(System.in);
    }
    
    public void ValidadorClave(){
        Conector conector = new Conector();
        
        System.out.print("Ingrese Contraseña: ");
        Passwd = s.nextLine();
        if (conector.getTablauserPassword(Passwd) == true) {
            System.out.println("Bienvenido");
            
        }
        else {
            System.out.println("Clave Incorrecta");
            do{
                if (conector.getTablauserPassword(Passwd) == false) {
                
                }
                
                System.out.print("Ingrese Contraseña: ");
                Passwd = s.nextLine();
                
                  
            
        }while (conector.getTablauserPassword(Passwd)== true);
           
        }
        
        
        
    }
              
       
}

    
    
    

