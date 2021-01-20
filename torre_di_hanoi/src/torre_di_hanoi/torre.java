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
        //System.out.println(a.get(0)+"mmm");
       disco prova= (disco)a.get(k);
        return prova;
    }
    
   
}
