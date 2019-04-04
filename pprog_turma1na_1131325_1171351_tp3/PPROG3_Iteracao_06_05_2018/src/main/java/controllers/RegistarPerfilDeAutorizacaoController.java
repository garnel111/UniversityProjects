/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controllers;

import java.text.ParseException;
import java.util.ArrayList;
import models.Empresa;
import models.Equipamento;
import models.ListaPeriodosDeAutorizacao;
import models.PerfilDeAutorizacao;
import models.RegistoPerfisDeAutorizacao;
import models.RegistoDeEquipamentos;

/**
 *
 * @author mjdg1
 */
public class RegistarPerfilDeAutorizacaoController {
    
    private Empresa m_Empresa;
    private RegistoPerfisDeAutorizacao registoPerfisDeAutorizacao;
    private PerfilDeAutorizacao perfilDeAutorizacao;
    private Equipamento equipamento;
    private RegistoDeEquipamentos registoDeEquipamentos;
    
    private ListaPeriodosDeAutorizacao periodosDeAutorizacao;
    private ArrayList<String> listaEquipamentos = new ArrayList<>();
    
    public RegistarPerfilDeAutorizacaoController(Empresa m_Empresa) {
        this.m_Empresa = m_Empresa;
        
    }
    
    public void novoPerfilDeAutorizacao() {
        registoPerfisDeAutorizacao = m_Empresa.getRegistoDePerfis();
        perfilDeAutorizacao = registoPerfisDeAutorizacao.novoPerfilDeAutorizacao();
        
    }
    
    public void setDados(String idPerfilDeAutorizacao, String descricao) {
        this.perfilDeAutorizacao.setIdPerfilDeAutorizacao(idPerfilDeAutorizacao);
        this.perfilDeAutorizacao.setDescricao(descricao);
        
    }
    
    public ArrayList<String> getListaDeEquipamentos() {
        
        registoDeEquipamentos = this.m_Empresa.getRegistoDeEquipamentos();
        ArrayList<Equipamento> listaDeEquipamentos = registoDeEquipamentos.getEquipamentos();
        for (Equipamento item : listaDeEquipamentos) {
            listaEquipamentos.add(item.toString());
        }
        return listaEquipamentos;
    }
    
    public void addEquipamentoById(String idEquipamento) {
        registoDeEquipamentos = this.m_Empresa.getRegistoDeEquipamentos();
        equipamento = registoDeEquipamentos.getEquipamentoById(idEquipamento);
    }
    
    public void addPeriodo(int diaDaSemana, String horaInicial, String horaFinal) throws ParseException {
        
        perfilDeAutorizacao.adicionaPeriodo(equipamento, diaDaSemana, horaInicial, horaFinal);
        
    }
    
    public String getPerfilDeAutorizacao() {
        
        return perfilDeAutorizacao.toString();
    }
    
    public boolean valida() {
        return this.validaPerfilDeAutorizacao();
    }
    
    private boolean validaPerfilDeAutorizacao() {
        boolean bRet = false;
        if (registoPerfisDeAutorizacao.validaPerfilDeAutorizacao(this.perfilDeAutorizacao));
        {
            
            bRet = true;
        }
        return bRet;
    }
    
    public boolean registaPerfildeAutorizacao() {
        return registoPerfisDeAutorizacao.registaPerfilDeAutorizacao(perfilDeAutorizacao);
    }
    
    @Override
    public String toString() {
        return "RegistarPerfilDeAutorizacaoController{" + "equipamento=" + equipamento + ", periodosDeAutorizacao=" + periodosDeAutorizacao + ", listaEquipamentos=" + listaEquipamentos + '}';
    }
    
}
