/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giancorlo_progetto_discordsales;

/**
 *
 * @author super
 */
public class utente {
    private String nome;
    private String password;
    private String mail;
    private Object immagine;

    public utente(String nome, String password, String mail, Object immagine) {
        this.nome = nome;
        this.password = password;
        this.mail = mail;
        this.immagine = immagine;
    }
    
}
