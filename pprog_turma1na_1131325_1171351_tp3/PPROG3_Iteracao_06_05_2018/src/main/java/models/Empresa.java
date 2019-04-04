/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package models;

import java.text.ParseException;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Empresa {
    
    private RegistoDeAcessos registoAcessos;
    private RegistoDeEquipamentos registoDeEquipamentos;
    private RegistoColaboradores registoColaboradores;
    private RegistoPerfisDeAutorizacao registoPerfisDeAutorizacao;
    private RegistoDeCartoes registoDeCartoes;
    
    public Empresa() throws ParseException {
        
        this.registoColaboradores = new RegistoColaboradores();
        this.registoPerfisDeAutorizacao = new RegistoPerfisDeAutorizacao();
        this.registoAcessos = new RegistoDeAcessos();
        this.registoDeEquipamentos = new RegistoDeEquipamentos();
        this.registoDeCartoes = new RegistoDeCartoes();
        
    }
    
    public Empresa(RegistoDeAcessos registoAcessos, RegistoDeEquipamentos registoDeEquipamentos, RegistoColaboradores registoColaboradores, RegistoPerfisDeAutorizacao registoPerfisDeAutorizacao) {
        this.registoAcessos = registoAcessos;
        this.registoDeEquipamentos = registoDeEquipamentos;
        this.registoColaboradores = registoColaboradores;
        this.registoPerfisDeAutorizacao = registoPerfisDeAutorizacao;
    }
    
    public Empresa(RegistoDeAcessos registoAcessos, RegistoDeEquipamentos registoDeEquipamentos, RegistoColaboradores registoColaboradores, RegistoPerfisDeAutorizacao registoPerfisDeAutorizacao, RegistoDeCartoes registoDeCartoes) {
        this.registoAcessos = registoAcessos;
        this.registoDeEquipamentos = registoDeEquipamentos;
        this.registoColaboradores = registoColaboradores;
        this.registoPerfisDeAutorizacao = registoPerfisDeAutorizacao;
        this.registoDeCartoes = registoDeCartoes;
    }
    
    public RegistoPerfisDeAutorizacao getRegistoDePerfis() {
        return this.registoPerfisDeAutorizacao;
    }
    
    public RegistoDeAcessos getRegistoAcessos() {
        return registoAcessos;
    }
    
    public RegistoDeEquipamentos getRegistoDeEquipamentos() {
        return registoDeEquipamentos;
    }
    
    public RegistoDeCartoes getRegistodeCartoes() {
        return this.registoDeCartoes;
    }
    
    public RegistoColaboradores getRegistoColaboradores() {
        return this.registoColaboradores;
    }
    
}
