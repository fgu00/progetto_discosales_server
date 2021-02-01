/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torre_di_hanoi;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author super
 */
public class Torre_di_hanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      colonne a=new colonne();
      Scanner sc=new Scanner(System.in);
        System.out.println("con quanti dischi vuoi giocare ?");
        int numero=sc.nextInt();
        System.out.println("inserisic il tuo nome");
        String nome=sc.next();
      a.dischi(numero,nome);
      a.menu();
    
     

    }
    
}
