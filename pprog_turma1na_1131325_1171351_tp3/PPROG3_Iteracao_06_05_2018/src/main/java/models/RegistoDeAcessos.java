/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Interfaces.Cartao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Altran
 */
public class RegistoDeAcessos {

    private ArrayList<AcessoAreaRestrita> acessos;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm aa");

    public RegistoDeAcessos() {
        this.acessos = new ArrayList<>();

    }

    public RegistoDeAcessos(ArrayList<AcessoAreaRestrita> acessos) {
        this.acessos = acessos;
    }

    
    
    
    public ArrayList<AcessoAreaRestrita> getListaAcessos() {
        return acessos;
    }

    public void setAcessos(ArrayList<AcessoAreaRestrita> acessos) {
        this.acessos = acessos;
    }

    /**
     *
     * @param intervaloTempo
     * @param cartao
     * @param colaborador
     * @param area
     */
    public void getListaAcessosFiltrada(int intervaloTempo, int cartao, int colaborador, int area) {
    }

    /**
     *
     * @param equipamento
     * @param cartao
     * @param colaborador
     * @param date
     * @param hour
     * @param sucesso
     * @param movimento
     */
    public void novoAcesso(Equipamento equipamento, Cartao cartao, Colaborador colaborador, LocalDate date, String hour, boolean sucesso, String movimento) {
        AcessoAreaRestrita acesso = new AcessoAreaRestrita(equipamento, cartao, colaborador, date, hour, sucesso, movimento);
        addAcesso(acesso);

    }

    /**
     *
     * @param acesso
     */
    public void addAcesso(AcessoAreaRestrita acesso) {
        this.acessos.add(acesso);
    }

}
