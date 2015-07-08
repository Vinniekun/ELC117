/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuildGUI;

import java.util.ArrayList;

/**
 *
 * @author vinnie
 */
public class Grupo extends ArrayList<Personagem>{
    
    private int integrantes; //numero de integrantes
    private String[] confirm = new String[7];
    
    public int getNumero() {
        return integrantes;
    }

    public void setNumero(int numero) {
        this.integrantes = numero;
    }

    public String getConfirm(int index) {
        return confirm[index];
    }

    public void setConfirm(String confirm, int index) {
        this.confirm[index] = confirm;
    }
    
    public boolean exceptionDias(){
        for(int i = 0; i < 7; i++){
            if (this.confirm[i]=="verdadeiro")
                return true;
        }
        return false;
    }
}
