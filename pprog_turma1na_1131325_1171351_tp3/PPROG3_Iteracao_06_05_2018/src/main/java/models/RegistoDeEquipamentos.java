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
public class RegistoDeEquipamentos {

    private ArrayList<Equipamento> equipamentos;

    public RegistoDeEquipamentos() {
        this.equipamentos = new ArrayList<>();
    }

    public RegistoDeEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public boolean registaEquipamento(Equipamento m_oEquipamento) {
        return addEquipamento(m_oEquipamento);
    }

    private boolean addEquipamento(Equipamento m_oEquipamento) {
        return equipamentos.add(m_oEquipamento);
    }

    public Equipamento getEquipamentoById(String idEquipamento) {
        for(Equipamento e:this.equipamentos){
            if(idEquipamento.equalsIgnoreCase(e.getId())){
                return e;
            }
        }
        return null;
    }

    public Equipamento novoEquipamento() {
        return new Equipamento();
    }

}
