/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torre_di_hanoi;

import java.util.Scanner;

/**
 *
 * @author super
 */
public class colonne {
   torre[]a;
   Scanner sc=new Scanner(System.in);
    public colonne(){
        a=new torre[3];
        a[0]=new torre();
        a[1]=new torre();
        a[2]=new torre();
    }
    public void dischi(int m){
        for(int h=0;h<m;h++){
            disco prova=new disco(h);
            a[0].push(prova);
            a[1].push(null);
            a[2].push(null);
        }
    }
    public void stampa(){
        for(int h=0;h<a[0].size();h++){
            if(a[0].posto(0)!=null){
            System.out.print("   "+a[0].posto(h).getNumero());
            }else{
            System.out.print("   ");
            }
            if(a[1].posto(0)!=null){
             System.out.print("           "+a[1].posto(h).getNumero());
            }else{
            System.out.print("            ");
            }
            if(a[2].posto(0)!=null){
              System.out.print("          "+a[2].posto(h).getNumero());
            }else{
            System.out.print("            ");
   
}
        System.out.println(" ");
    }
        System.out.print("colonna 1  ");
        System.out.print("colonna 2  ");
        System.out.print("colonna 3  ");
        System.out.println(" ");
        System.out.println("----------------------------------------------------------");
        System.out.println("1 per fare una mossa");
        System.out.println("2 per uscire");
        System.out.println("----------------------------------------------------------");
}
    public void menu(){
    int e=sc.nextInt();
    switch(e){
        case 1:
            mossa();
            break;
        case 2:
            
            break;
    }
    }
    public void mossa(){
        System.out.println("selezionale la colonna con ciu vuoi fare lo spostamento");
        int numero=sc.nextInt();
        switch(numero){
            case 1:
                disco prova=null;
                prova=cerca(0);
                System.out.println("seleziona la colonna dove vuoi inserire il disco");
                int t=sc.nextInt();
                controllomossa(prova,0,t-1);
                break;
                
        }
    }
    public disco cerca(int colonna){
        disco trova=null;
        for(int h=0;h<a[colonna].size();h++){
            if(a[colonna].top()!=null){
                trova=(disco) a[colonna].top();
                //da togliere
                System.out.println(trova.getNumero());
                break;
            }
        }
       return trova ;
        
    }
    //da fizzare tutto
    public void controllomossa(disco metto,int colonna,int colonnaN){
        if(a[colonnaN].posto(a[colonnaN].size()-1)!=null){
        if(metto.getNumero()<a[colonnaN].posto(a[colonnaN].size()-1).getNumero()){
            //da togliere
            System.out.println(metto.getNumero());
            a[colonnaN].push(metto);
            a[colonna].pop();
            
        }
    }else{
     System.out.println(metto.getNumero());
            a[colonnaN].push(metto);
            a[colonna].pop();  
            //da togliere
          System.out.println(  a[colonnaN].posto(2).getNumero());
    }
    }
    }

