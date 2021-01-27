/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torre_di_hanoi;

import java.util.Vector;

/**
 *
 * @author super
 */
public class torre extends pila{

    public torre(){
       
    }
    public disco posto(int k){
       disco prova= (disco)a.get(k);
        return prova;
    }
    public disco mossaP(){
        disco trova=null;
        for(int j=a.size()-1;j>=0;j--){
            if(a.get(j)!=null){
                trova=(disco) a.get(j);
                
            }
        }
        return trova;
        
    }
    public void togli(disco togli){
       for(int j=0;j<a.size();j++){
           if(togli==a.get(j)){
               a.setElementAt(null, j);
               j=a.size();
           }
       } 
    }
    public void sostituisci(disco sostituto){
        for(int j=a.size()-1;j>=0;j--){
            if(a.get(j)==null){
                a.setElementAt(sostituto, j);
                break;
            }
        }
    }
    
   
}
