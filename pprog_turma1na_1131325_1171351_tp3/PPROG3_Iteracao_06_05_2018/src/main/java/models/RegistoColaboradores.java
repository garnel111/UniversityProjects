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
public class RegistoColaboradores {
    
    private ArrayList<Colaborador> colaboradores;
    private Colaborador colaborador;

    public RegistoColaboradores(ArrayList<Colaborador> colaboradores, Colaborador colaborador) {
        this.colaboradores = colaboradores;
        this.colaborador = colaborador;
    }

    
    public RegistoColaboradores(Colaborador colaborador) {
 
        this.colaboradores = new ArrayList<>();
              
    }

    public RegistoColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

   
    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
    public RegistoColaboradores() {
        
        this.colaboradores = new ArrayList<>();
    }
    
    public Colaborador novoColaborador() {
        return new Colaborador();
    }
    
    public boolean validaColaborador(Colaborador colaborador) {
        return colaborador.valida();
        
    }
    
    public boolean registaColaborador(Colaborador m_colaborador) {
        if (this.validaColaborador(m_colaborador)) {
            addColaborador(m_colaborador);
            return true;
        }
        return false;
    }
    
    private void addColaborador(Colaborador m_colaborador) {
        colaboradores.add(m_colaborador);
        
    }
 
  
}
