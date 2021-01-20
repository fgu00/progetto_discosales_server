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
public class pila {
       Vector a;

    public pila() {
      a=new Vector();
    }
    public void push(disco b){
        a.add(b);
    }
    public Object pop(){
        Object b=null;
        if(!a.isEmpty()){
             b=a.lastElement();
            a.remove(b);
        }
        return b;
    }
    public Object top(){
        Object b=null;
        if(!a.isEmpty()){
            b=a.lastElement();
            
        }
        return b;
    }
    
    
    public boolean vuota(){
        if(!a.isEmpty()){
          return false;  
        }
        return true;
        
    }
    public int size(){
        return a.size();
        
    }
    public void clear(){
        a.clear();
    }
    
}
 

