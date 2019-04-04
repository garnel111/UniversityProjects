/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author mjdg1
 */
public class RegistoPerfisDeAutorizacao {
    
    private ArrayList<PerfilDeAutorizacao> perfisDeAutorizacao;

    public RegistoPerfisDeAutorizacao(ArrayList<PerfilDeAutorizacao> perfisDeAutorizacao) {
        this.perfisDeAutorizacao = perfisDeAutorizacao;
    }

    
    
    public RegistoPerfisDeAutorizacao() {
        this.perfisDeAutorizacao = new ArrayList<>();
            
    }

    public  ArrayList<PerfilDeAutorizacao> getPerfis() {
       return perfisDeAutorizacao;
    }

    public PerfilDeAutorizacao getPerfilById(int perfiId) {
               
      return perfisDeAutorizacao.get(perfiId);
    }

    public PerfilDeAutorizacao novoPerfilDeAutorizacao() {
        return new PerfilDeAutorizacao();
    }

    public boolean validaPerfilDeAutorizacao(PerfilDeAutorizacao perfilDeAutorizacao) {
       return perfilDeAutorizacao.valida();
    }

    public boolean registaPerfilDeAutorizacao(PerfilDeAutorizacao perfilDeAutorizacao) {
        if(this.validaPerfilDeAutorizacao(perfilDeAutorizacao)){
            addPerfilDeAutorizacao(perfilDeAutorizacao);
            return true;
    }
    return false;
    }

    private void addPerfilDeAutorizacao(PerfilDeAutorizacao perfilDeAutorizacao) {
       
        perfisDeAutorizacao.add(perfilDeAutorizacao);
       
    }
}
