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
            if(a[0].posto(h)!=null){
            System.out.print("   "+a[0].posto(h).getNumero());
            }else{
            System.out.print("   ");
            }
            if(a[1].posto(h)!=null){
             System.out.print("           "+a[1].posto(h).getNumero());
            }else{
            System.out.print("            ");
            }
            if(a[2].posto(h)!=null){
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
        int contatore=0;
        boolean attiva=true;
        while(attiva==true){
            stampa();
    int e=sc.nextInt();
    switch(e){
        case 1:
            mossa();
            attiva=vincita(contatore);
            contatore++;
            break;
        case 2:
            attiva=false;
            break;
    }
        }
    }
    public void mossa(){
        System.out.println("selezionale la colonna con cui vuoi fare lo spostamento");
        int numero=sc.nextInt();
        switch(numero){
            case 1:
                disco prova=null;
                prova=cerca(0);
                System.out.println("seleziona la colonna dove vuoi inserire il disco");
                int t=sc.nextInt();
                controllomossa(prova,0,t-1);
                break;
            case 2:
                disco prova1=null;
                prova1=cerca(1);
                System.out.println("seleziona la colonna dove vuoi inserire il disco");
                int t1=sc.nextInt();
                controllomossa(prova1,1,t1-1);
                break;
            case 3:
                disco prova2=null;
                prova2=cerca(2);
                System.out.println("seleziona la colonna dove vuoi inserire il disco");
                int t2=sc.nextInt();
                controllomossa(prova2,2,t2-1);
                break; 
        }
    }
    public disco cerca(int colonna){
        disco trova=null;
        for(int h=0;h<a[colonna].size();h++){
            if(a[colonna].top()!=null){
                trova=(disco) a[colonna].mossaP();
                break;
            }
        }
       return trova ;
        
    }
    public void controllomossa(disco metto,int colonna,int colonnaSpostamento){
        if(a[colonnaSpostamento].posto(2)==null){
            a[colonnaSpostamento].sostituisci(metto);
            a[colonna].togli(metto);
        }else{
            int posizione=0;
            for(int j=0;j<a[colonnaSpostamento].size();j++){
                if(a[colonnaSpostamento].posto(j)!=null){
                    posizione=j;
                    break;
                }
            }
             if(a[colonnaSpostamento].posto(posizione).getNumero()>metto.getNumero()){
                 a[colonnaSpostamento].sostituisci(metto);
                 a[colonna].togli(metto); 
             }else{
                 System.out.println("non puoi inserire un disco più grande su uno più piccolo");
             }  
            }
        

    }
    public boolean vincita(int numero){
        int vincita=0;
        for(int h=0;h<a[1].size()-1;h++){
            if(a[1].posto(h)!=null){
            if(a[1].posto(h).getNumero()<a[1].posto(h+1).getNumero()){
                vincita++;
            }
        }
        }
        if(vincita==2){
            stampa();
            System.out.println("hai vinto in : "+numero);
            return false;
        }
        for(int h=0;h<a[2].size()-1;h++){
            if(a[2].posto(h)!=null){
            if(a[2].posto(h).getNumero()<a[2].posto(h+1).getNumero()){
                vincita++;
            }
        }
        }
        if(vincita==2){
            stampa();
            System.out.println("hai vinto in : "+numero);
            return false;
        }
       return true;
        
    }
    }


