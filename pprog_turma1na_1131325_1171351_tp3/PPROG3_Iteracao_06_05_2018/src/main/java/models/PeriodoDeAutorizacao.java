/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package models;

import java.io.Serializable;
/**
 *
 * @author mjdg1
 */
public class PeriodoDeAutorizacao implements Serializable{
 
    private int day;
    private String inicialHour;
    private String finalHour;
    private Equipamento equipamento;

 
    public PeriodoDeAutorizacao() {
    }

    public PeriodoDeAutorizacao(int day, String inicialHour, String finalHour, Equipamento equipamento) {
        this.day = day;
        this.inicialHour = inicialHour;
        this.finalHour = finalHour;
        this.equipamento = equipamento;
    }

  
    public PeriodoDeAutorizacao(Equipamento equipamento, int diaDaSemana, String horaInicial, String horaFinal) {
        this.day = diaDaSemana;
        this.inicialHour = horaInicial;
        this.finalHour = horaFinal;
        this.equipamento = equipamento;
    }
    
    public int getDay() {
        return day;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public String getInicialHour() {
        return inicialHour;
    }
    
    public void setInicialHour(String inicialHour) {
        this.inicialHour = inicialHour;
    }
    
    public String getFinalHour() {
        return finalHour;
    }
    
    public void setFinalHour(String finalHour) {
        this.finalHour = finalHour;
    }
    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
     

    public boolean valida() {
          if(this.day >0 && this.day <8 && this.inicialHour != null && this.finalHour != null && this.equipamento.valida()){
           return true;
       }
       return false;
    }

    @Override
    public String toString() {
        return "PeriodoDeAutorizacao:\n" + "\t day= " + day + ", inicialHour= " + inicialHour + ", finalHour= " + finalHour + ", equipamento= " + equipamento ;
    }
    
}
