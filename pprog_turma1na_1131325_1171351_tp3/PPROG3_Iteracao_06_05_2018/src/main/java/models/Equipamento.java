/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package models;

import java.io.Serializable;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Equipamento implements Serializable {
    
    private String m_id;
    private String m_sEnderecoLogico;
    private String m_sEnderecoFisico;
    private String m_sFicheiroConfiguracao;
    
    private String fabricante;
    private String modelo;
    private String movimento;
    
    private AreaRestrita areaRestrita;
    
    public Equipamento() {
    }
    
    public Equipamento novoEquipamento() {
        return new Equipamento();
    }
    
    public Equipamento(String sid, String sEnderecoLogico, String sEnderecoFisico, String sFicheiroConfiguracao, String modelo, String fabricante, String movimento, AreaRestrita area) {
        this.setDescricao(sid);
        this.setEnderecoLogico(sEnderecoLogico);
        this.setEnderecoFisico(sEnderecoFisico);
        this.setFicheiroConfiguracao(sFicheiroConfiguracao);
        this.setFabricante(fabricante);
        this.setModelo(modelo);
        this.setMovimento(movimento);
        this.areaRestrita = new AreaRestrita();
        this.setAreaRestrita(area);
        
    }
    
    public String getId() {
        return this.m_id;
    }
    
    public void setDescricao(String sId) {
        this.m_id = sId;
    }
    
    public void setEnderecoLogico(String sEnderecoLogico) {
        this.m_sEnderecoLogico = sEnderecoLogico;
    }
    
    public String getEnderecoLogico() {
        return this.m_sEnderecoLogico;
    }
    
    public void setEnderecoFisico(String sEnderecoFisico) {
        this.m_sEnderecoFisico = sEnderecoFisico;
    }
    
    public void setFicheiroConfiguracao(String sFicheiroConfiguracao) {
        this.m_sFicheiroConfiguracao = sFicheiroConfiguracao;
    }
    
    public String getMovimento() {
        return movimento;
    }
    
    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }
    
    public AreaRestrita getAreaRestrita() {
        return this.areaRestrita;
    }
    
    public void setAreaRestrita(AreaRestrita area) {
        this.areaRestrita = area;
    }
    
    public String getFabricante() {
        return fabricante;
    }
    
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public boolean valida() {
        return validaEquipamento();
        
    }
    
    public boolean isIdentifiableAs(String sID) {
        return this.m_sEnderecoLogico.equals(sID);
    }
    
    public String getM_sEnderecoLogico() {
        return m_sEnderecoLogico;
    }
    
    public void setM_sEnderecoLogico(String m_sEnderecoLogico) {
        this.m_sEnderecoLogico = m_sEnderecoLogico;
    }
    
    public String getM_sEnderecoFisico() {
        return m_sEnderecoFisico;
    }
    
    public void setM_sEnderecoFisico(String m_sEnderecoFisico) {
        this.m_sEnderecoFisico = m_sEnderecoFisico;
    }
    
    @Override
    public String toString() {
        return "Equipamento{" + "m_id=" + m_id + ", m_sEnderecoLogico=" + m_sEnderecoLogico + ", m_sEnderecoFisico=" + m_sEnderecoFisico + ", m_sFicheiroConfiguracao=" + m_sFicheiroConfiguracao + ", fabricante=" + fabricante + ", modelo=" + modelo + ", movimento=" + movimento + ", areaRestrita=" + areaRestrita + '}';
    }
    
    private boolean validaEquipamento() {
        boolean bRet = false;
        if (this.m_id != null && this.m_sEnderecoFisico != null && this.m_sEnderecoLogico != null && this.m_sFicheiroConfiguracao != null) {
            bRet = true;
        }
        
        return bRet;
    }
    
}
