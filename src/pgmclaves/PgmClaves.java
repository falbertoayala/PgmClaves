/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmclaves;

/**
 *
 * @author Desarrollo
 */
import java.io.Console;
import java.util.Scanner;

public class PgmClaves {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        //Console console = System.console();
        Scanner sc = new Scanner(System.in);
        Validador validador = new Validador();

        //String password ;
        //Console console = null;
        System.out.println("Bienvenido a tu Gestor de Contraseña");
        System.out.println("********************************************************************");
        Conector conector = new Conector();
        System.out.print("Favor Ingresa tu Usuario : ");
        String user = sc.nextLine();
        conector.getTablauser(user);
        if (conector.getTablauser(user) == true) {
            validador.ValidadorClave();
           

        } else {
            
            Conector cn = new Conector();
            System.out.println("MENU DE CREACION DE USUARIOS");
            System.out.println("Ingrese Nombre :");
            String name = sc.nextLine();
            System.out.print("Ingrese su Correo :");
            String email = sc.nextLine();
            System.out.print("Ingrese su Password :");
            //password = console.readPassword(password, args);
            //String password = new String(console.readPassword());
            String password = sc.nextLine();
            cn.insertarUsuarios(name, email, password);

        }

    }
    

}
