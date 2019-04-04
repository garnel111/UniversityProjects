/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mjdg1
 */
public class PerfilDeAutorizacao implements Serializable{

    private String idPerfilDeAutorizacao;
    private String descricao;
    private ListaPeriodosDeAutorizacao listaPeriodosDeAutorizacao;

    public PerfilDeAutorizacao(String idPerfilDeAutorizacao, String descricao, ListaPeriodosDeAutorizacao listaPeriodosDeAutorizacao) {
        this.idPerfilDeAutorizacao = idPerfilDeAutorizacao;
        this.descricao = descricao;
        this.listaPeriodosDeAutorizacao = listaPeriodosDeAutorizacao;
    }

    public PerfilDeAutorizacao(String idPerfilDeAutorizacao, String descricao) {
        this.idPerfilDeAutorizacao = idPerfilDeAutorizacao;
        this.descricao = descricao;
        listaPeriodosDeAutorizacao = new ListaPeriodosDeAutorizacao();
    }

    public PerfilDeAutorizacao() {
        listaPeriodosDeAutorizacao = new ListaPeriodosDeAutorizacao();
    }

    public String getIdPerfilDeAutorizacao() {
        return idPerfilDeAutorizacao;
    }

    public void setIdPerfilDeAutorizacao(String idPerfilDeAutorizacao) {
        this.idPerfilDeAutorizacao = idPerfilDeAutorizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean valida() {

        if (this.descricao != null && this.idPerfilDeAutorizacao != null) {
            if (listaPeriodosDeAutorizacao.valida()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "PerfilDeAutorizacao{" + "idPerfilDeAutorizacao=" + idPerfilDeAutorizacao + ", descricao=" + descricao + ", listaPeriodosDeAutorizacao=" + listaPeriodosDeAutorizacao + '}';
    }

    public void adicionaPeriodo(Equipamento equipamento, int dia, String horaInicial, String horaFinal) {

        listaPeriodosDeAutorizacao.criaPeriodo(equipamento, dia, horaInicial, horaFinal);

    }

    public boolean isEquipamentoAutorizado(String idEquipamento, LocalDate localDate, String hourString) {
        int diaDaSemana = localDate.getDayOfWeek().getValue();
        ArrayList<PeriodoDeAutorizacao> periodos = this.listaPeriodosDeAutorizacao.getListaPeriodosDeAutorizacao();

        for (PeriodoDeAutorizacao p : periodos) {
            if (p.getEquipamento().getId().equalsIgnoreCase(idEquipamento) && hourString.compareTo(p.getInicialHour()) >= 0 && hourString.compareTo(p.getFinalHour()) <= 0 && diaDaSemana == p.getDay()) {
                return true;
            }
        }
        return false;
    }

    public Object getListaPeriodosDeAutorizacao() {
       return listaPeriodosDeAutorizacao;
    }

}
