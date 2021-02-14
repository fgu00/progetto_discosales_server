/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torre_di_hanoi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author super
 */
public class colonne {
   private torre[]a;
   private Scanner sc=new Scanner(System.in);
   private String nome;
   private int mosse=0;
   private int dischi=0;
   private ArrayList <String>lista =new ArrayList<String>();  
   private ArrayList <String>giacata =new ArrayList<String>(); 
   private String cronologia="";
   private ArrayList<String>persone=new ArrayList<String>();
    private ArrayList<Integer>punteggio=new ArrayList<Integer>();
    private ArrayList<String>scarto=new ArrayList<String>();
    private ArrayList<Integer>Ndischi=new ArrayList<Integer>();
    private boolean esiste=false;
    public colonne(){
        a=new torre[3];
        a[0]=new torre();
        a[1]=new torre();
        a[2]=new torre();
        
    }
    public void dischi(int m,String nome){
        for(int h=0;h<m;h++){
            disco prova=new disco(h);
            a[0].push(prova);
            a[1].push(null);
            a[2].push(null);
            this.nome=nome;
            dischi=m;
        }
    }
    public void stampa(){
        for(int h=0;h<a[0].size();h++){
            if(a[0].posto(h)!=null){
            System.out.print("   "+a[0].posto(h).getNumero());
            }else{
            System.out.print("    ");
            }
            if(a[1].posto(h)!=null){
             System.out.print("           "+a[1].posto(h).getNumero());
            }else{
            System.out.print("            ");
            }
            if(a[2].posto(h)!=null){
              System.out.print("          "+a[2].posto(h).getNumero());
            }else{
            System.out.print("           ");
   
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
    public void menu() throws IOException{
        leggi();
        classifica();
        scelta();
        int contatore=0;
        boolean attiva=true;
        while(attiva==true){
            stampa();
    int e=sc.nextInt();
    switch(e){
        case 1:
            mossa();
            giacata.add(cronologia);
            cronologia="";
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
        if(a[colonnaSpostamento].posto(a[colonnaSpostamento].size()-1)==null){
            a[colonnaSpostamento].sostituisci(metto);
            a[colonna].togli(metto);
            cronologia=nome+" ha spostato il disco "+metto.getNumero()+" dalla colonna "+(colonna+1)+" alla colonna "+(colonnaSpostamento+1);
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
                 cronologia=nome+" ha spostato il disco "+metto.getNumero()+" dalla colonna "+(colonna+1)+" alla colonna "+(colonnaSpostamento+1);
             }else{
                 System.out.println("non puoi inserire un disco più grande su uno più piccolo");
                 cronologia=nome+" ha eseguito una mossa non valida";
             }  
            }
        

    }
    public boolean vincita(int numero) throws IOException{
        int vincita=0;
        for(int h=0;h<a[1].size()-1;h++){
            if(a[1].posto(h)!=null){
            if(a[1].posto(h).getNumero()<a[1].posto(h+1).getNumero()){
                vincita++;
            }
        }
        }
        if(vincita==dischi-1){
            stampa();
            System.out.println("hai vinto in : "+(numero+1)+" mosse");
            mosse=numero;
            cronologia=nome+" ha vinto ";
            giacata.add(cronologia);
            controllo();
            salva();
            return false;
        }
        for(int h=0;h<a[2].size()-1;h++){
            if(a[2].posto(h)!=null){
            if(a[2].posto(h).getNumero()<a[2].posto(h+1).getNumero()){
                vincita++;
            }
        }
        }
        if(vincita==dischi-1){
            stampa();
            System.out.println("hai vinto in : "+(numero+1)+" mosse");
            mosse=numero;
            cronologia=nome+" ha vinto ";
            giacata.add(cronologia);
            controllo();
            salva();
            return false;
        }
       return true;
        
    }
    public void salva() throws IOException{
       // File nuovo=new File("C:\\Users\\russo.salvatore\\Desktop\\classifica\\vincitori.txt");
       File nuovo=new File("C:\\Users\\super\\OneDrive\\Desktop\\classifica\\vincitori.TXT");
        FileWriter scrivi=new FileWriter(nuovo);
        for(int e=0;e<lista.size();e++){
            scrivi.write(lista.get(e));
            scrivi.write("\n");
        }
        if(esiste==false){
        scrivi.write(nome+" ha vinto in "+mosse+" mosse con un totale di "+dischi+" dischi");
        scrivi.write("\n");
        }
        scrivi.flush();
        scrivi.close();
         //File giocatore=new File("C:\\Users\\russo.salvatore\\Desktop\\classifica\\"+nome+".txt");
         File giocatore=new File("C:\\Users\\super\\OneDrive\\Desktop\\classifica\\"+nome+".TXT");
          FileWriter classifica=new FileWriter(giocatore);
         for(int k=0;k<giacata.size();k++){
          classifica.write(giacata.get(k));
          classifica.write("\n");
          
         }
         
         classifica.flush();
         classifica.close();
      
    }
    
    public void leggi() throws FileNotFoundException{
       //  File nuovo=new File("C:\\Users\\russo.salvatore\\Desktop\\classifica\\vincitori.txt");
       File nuovo=new File("C:\\Users\\super\\OneDrive\\Desktop\\classifica\\vincitori.TXT");
       Scanner leggi=new Scanner(nuovo);
       while(leggi.hasNextLine()){
       String linea=leggi.nextLine();
           lista.add(linea);
       }
    }
    public void classifica() throws FileNotFoundException, IOException{
    // FileReader a=new FileReader("C:\\Users\\russo.salvatore\\Desktop\\classifica\\vincitori.txt");
      FileReader a=new FileReader("C:\\Users\\super\\OneDrive\\Desktop\\classifica\\vincitori.TXT");
         BufferedReader leggi=new BufferedReader(a);
     boolean cerca=true;
     while(cerca==true){
       String nome1=leggi.readLine();
       if(nome1==null){
           break;
       }
      String []n=nome1.split(" ");
      for(int i=0;i<n.length;i++){
          scarto.add(n[i]); 
          
      }    
       }
     
        cerca();
      leggi.close();
    
     }
      
    
    public void controllo(){
        for(int n=0;n<persone.size();n++){
          if(nome.equals(persone.get(n))){
           if(mosse<=punteggio.get(n)){
                lista.remove(n);
            }  
          }  
        } 
      }   
   
      
    
    public void cerca(){
        int conta=0;
       for(int n=0;n<scarto.size()-1;n++){
       if(n==(0+conta)){
           persone.add(scarto.get(n));
           
       }
       if(n==(4+conta)){
           int o=Integer.parseInt(scarto.get(n));
           punteggio.add(o);
       }
       if(n==(10+conta)){
           Ndischi.add(Integer.parseInt(scarto.get(n)));
           conta=conta+12;
           
       }
     }  
    }
    public void scelta() throws FileNotFoundException, IOException{
        boolean ciclo=true;
        while(ciclo==true){
        System.out.println("1 per avere la classifica");
        System.out.println("2 per cercare un giocatore");
        System.out.println("3 per giocare");
        int scelta=sc.nextInt();
        switch(scelta){
            case 1:
                for(int k=0;k<lista.size();k++){
                    System.out.println(lista.get(k));
                }
                System.out.println(" ");
            break;
            case 2:
                System.out.println("inserisci il nome del giocatore");
                String nome=sc.next();
                for(int y=0;y<persone.size();y++){
                    if(nome.equals(persone.get(y))){
                        System.out.println(lista.get(y));
                        // File f1=new File("C:\\Users\\russo.salvatore\\Desktop\\classifica\\"+nome+".txt");
                File f1=new File("C:\\Users\\super\\OneDrive\\Desktop\\classifica\\"+nome+".TXT");
                 FileReader a=new FileReader(f1);
                BufferedReader leggi=new BufferedReader(a);
                String s=leggi.readLine();
                while(s!=null){
                    System.out.println(s);
                    s=leggi.readLine(); 
                }
                leggi.close();
                a.close();
                break;
                    }
                    System.out.println(" ");
                
                    
                }
                
            break;
            case 3:
                ciclo=false;
                break;
        }
    }
}
}


