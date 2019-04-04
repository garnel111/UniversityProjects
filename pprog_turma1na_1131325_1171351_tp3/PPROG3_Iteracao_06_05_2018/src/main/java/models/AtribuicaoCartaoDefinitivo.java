/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package models;

import Interfaces.AtribuicaoDeCartao;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * Representa uma Atribuição de um Cartão Definitivo
 */
public class AtribuicaoCartaoDefinitivo implements AtribuicaoDeCartao, Serializable {
    
    /**
     * data de atribuição do cartão
     */
    private LocalDate dataAtribuicao;
    /**
     * data de início da validade do cartão
     */
    private LocalDate dataInicio;
    /**
     * data de fim da validade do cartão
     */
    private LocalDate dataFim;
    /**
     * colaborador associado ao cartão
     */
    private Colaborador colaborador;
    
    /**
     * Constrói uma instância de AtribuicaoCartaoDefinitivo recebendo os
     * seguinte parâmetros:
     *
     * @param dataAtribuicao
     * @param dataInicio
     * @param dataFim
     * @param colaborador
     */
    public AtribuicaoCartaoDefinitivo(LocalDate dataAtribuicao, LocalDate dataInicio, LocalDate dataFim, Colaborador colaborador) {
        this.dataAtribuicao = dataAtribuicao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.colaborador = colaborador;
    }
    
    /**
     * Constrói uma instância de AtribuicaoCartaoDefinitivo
     */
    public AtribuicaoCartaoDefinitivo() {
    }
    
    /**
     * Devolve a data de atribuição do cartão
     *
     * @return
     */
    public LocalDate getDataAtribuicao() {
        return dataAtribuicao;
    }
    
    /**
     * Modifica a data de atribuição do cartão
     *
     * @param dataAtribuicao
     */
    public void setDataAtribuicao(LocalDate dataAtribuicao) {
        this.dataAtribuicao = dataAtribuicao;
    }
    
    /**
     * Devolve a data de início do cartão
     *
     * @return
     */
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    
    /**
     * Modifica a data de início do cartão
     *
     * @param dataInicio
     */
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    /**
     * Devolve a data de validade do cartão
     *
     * @return
     */
    public LocalDate getDataFim() {
        return dataFim;
    }
    
    /**
     * Modifica a data de validade do cartão
     *
     * @param dataFim
     */
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    
    /**
     * Devolve o colaborador associado ao cartão
     *
     * @return
     */
    @Override
    public Colaborador getColaborador() {
        return this.colaborador;
    }
    
    /**
     * Valida se a data recebida por parâmetro está contida no período de
     * validade do cartão
     *
     * @param date
     * @return true se a data recebida por parâmetro estiver contida no período
     * de validade do cartão
     */
    @Override
    public boolean pertencePeriodo(LocalDate date) {
        if ((date.isAfter(dataInicio) || date.isEqual(dataInicio)) && (date.isBefore(dataFim) || date.isEqual(dataFim))) {
            return true;
        }
        return false;
    }
    
    /**
     * Valida a instância cartão
     *
     * @return
     */
    @Override
    public boolean valida() {
        return true;
    }
    
    /**
     * Devolve a descrição textual do cartão
     *
     * @return
     */
    @Override
    public String toString() {
        return "AtribuicaoCartaoDefinitivo{" + "dataAtribuicao=" + dataAtribuicao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", colaborador=" + colaborador + '}';
    }
    
}
