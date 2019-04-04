/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.ParseConversionEvent;
import utils.Utils;

/**
 *
 * @author mjdg1
 */
public class ListaPeriodosDeAutorizacao implements Serializable {
    
    PeriodoDeAutorizacao periodoDeAutorizacao1 = new PeriodoDeAutorizacao();
    public ArrayList<PeriodoDeAutorizacao> listaPeriodosDeAutorizacao = new ArrayList<>();
    
    public ArrayList<PeriodoDeAutorizacao> getListaPeriodosDeAutorizacao() {
        return listaPeriodosDeAutorizacao;
    }
    
    public void setListaPeriodosDeAutorizacao(ArrayList<PeriodoDeAutorizacao> listaPeriodosDeAutorizacao) {
        this.listaPeriodosDeAutorizacao = listaPeriodosDeAutorizacao;
    }
    
    public ListaPeriodosDeAutorizacao(ArrayList<PeriodoDeAutorizacao> listaPeriodosDeAutorizacao) {
        this.listaPeriodosDeAutorizacao = listaPeriodosDeAutorizacao;
    }
    
    public boolean addPeriododeAutorizaca() {
        return listaPeriodosDeAutorizacao.add(periodoDeAutorizacao1);
    }
    
    public ListaPeriodosDeAutorizacao() {
        this.listaPeriodosDeAutorizacao = new ArrayList<>();
    }
    
    public void criaPeriodo(Equipamento equipamento, int diaDaSemana, String horaInicial, String horaFinal) {
        PeriodoDeAutorizacao periodoDeAutorizacao = new PeriodoDeAutorizacao(equipamento, diaDaSemana, horaInicial, horaFinal);
        
        listaPeriodosDeAutorizacao.add(periodoDeAutorizacao);
        
    }
    
    public boolean valida() {
        if (listaPeriodosDeAutorizacao.size() >= 1) {
            for (PeriodoDeAutorizacao item : listaPeriodosDeAutorizacao) {
                if (!item.valida()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return listaPeriodosDeAutorizacao.toString();
    }
    
}
