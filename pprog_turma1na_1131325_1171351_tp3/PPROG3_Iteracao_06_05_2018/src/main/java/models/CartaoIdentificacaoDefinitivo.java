package models;

import Interfaces.AtribuicaoDeCartao;
import Interfaces.Cartao;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * Representa um Cartão de Identificação Definitivo
 */
public class CartaoIdentificacaoDefinitivo implements Cartao, Serializable {
    
    /**
     * id do cartão
     */
    private int cartaoId;
    /**
     * data de emissão do cartão
     */
    private LocalDate date;
    /**
     * versão do cartão
     */
    private int versao;
    /**
     * lista que guarda todas as atribuições do cartão
     */
    private ArrayList<AtribuicaoDeCartao> atribuicoes;
    
    /**
     * Constrói uma instância de CartaIdentificacaoDefinitivo recebendo os
     * seguintes parâmetros:
     *
     * @param cartaoId
     * @param date
     * @param versao
     * @param atribuicoes
     */
    public CartaoIdentificacaoDefinitivo(int cartaoId, LocalDate date, int versao, ArrayList<AtribuicaoDeCartao> atribuicoes) {
        this.cartaoId = cartaoId;
        this.date = date;
        this.versao = versao;
        this.atribuicoes = atribuicoes;
    }
    
    /**
     * Constrói uma instância de CartaIdentificacaoDefinitivo recebendo os
     * seguintes parâmetros:
     *
     * @param cartaoId
     * @param date
     * @param versao
     */
    public CartaoIdentificacaoDefinitivo(int cartaoId, LocalDate date, int versao) {
        this.cartaoId = cartaoId;
        this.date = date;
        this.versao = versao;
        this.atribuicoes = new ArrayList<>();
    }
    
    /**
     * Constrói uma instância de CartaIdentificacaoDefinitivo
     */
    public CartaoIdentificacaoDefinitivo() {
        
    }
    
    /**
     * Devolve se o cartão é definitivo ou provisório
     *
     * @return true se o cartão for definitivo
     */
    @Override
    public boolean eDefinitivo() {
        return true;
    }
    
    /**
     * Devolve o colaborador associado ao cartão para uma data recebida por
     * parâmetro
     *
     * @param date
     * @return colaborador
     */
    @Override
    public Colaborador getColaboradorAtribuido(LocalDate date) {
        boolean pertence = false;
        int size = atribuicoes.size();
        int i = 0;
        while (i != size && !pertence) {
            AtribuicaoDeCartao a = atribuicoes.get(i);
            if (a.pertencePeriodo(date)) {
                pertence = true;
                return a.getColaborador();
            }
            i++;
        }
        return null;
    }
    
    /**
     * Devolve se o cartão é definitivo ou provisório
     *
     * @return true se o cartão for provisório
     */
    @Override
    public boolean eProvisorio() {
        return false;
    }
    
    /**
     * Regista uma nova atribuição
     *
     * @param novaAC
     * @return true se a atribuição for guardada com sucesso
     */
    @Override
    public boolean registaAtribuicao(AtribuicaoDeCartao novaAC) {
        if (novaAC.valida()) {
            this.atribuicoes.add(novaAC);
            return true;
        }
        return false;
    }
    
    /**
     * Devolve a lista de atribuições do cartão
     *
     * @return
     */
    public ArrayList<AtribuicaoDeCartao> getAtribuicoes() {
        return atribuicoes;
    }
    
    /**
     * Modifica o id do cartão
     *
     * @param numeroIdentificacao
     */
    public void setCartaoId(int numeroIdentificacao) {
        this.cartaoId = numeroIdentificacao;
    }
    
    /**
     * Modifica a data de emissão do cartão
     *
     * @param dataEmissao
     */
    public void setDataEmissao(LocalDate dataEmissao) {
        this.date = dataEmissao;
    }
    
    /**
     * Devolve a data de emissão do cartão
     *
     * @return
     */
    public LocalDate getDataEmissao() {
        return this.date;
    }
    
    /**
     * Modifica a versão do cartão
     *
     * @param versao
     */
    public void setVersao(int versao) {
        this.versao = versao;
    }
    
    /**
     * Devolve o id do cartão
     *
     * @return
     */
    @Override
    public int getCartaoId() {
        return this.cartaoId;
    }
    
    /**
     * Valida o cartão
     *
     * @return
     */
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
        return "CartaoIdentificacaoDefinitivo{" + "cartaoId=" + cartaoId + ", date=" + date + ", versao=" + versao + ", atribuicoes=" + atribuicoes + '}';
    }
    
    /**
     * Valida se o cartão possui o id recebido por parâmetro
     *
     * @param cartaoID
     * @return
     */
    @Override
    public boolean isCartao(int cartaoID) {
        return true;
    }
    
    /**
     * Valida a atribuição do cartão
     *
     * @param novaAC
     * @return true se a atribuição for válida
     */
    @Override
    public boolean validaAtribuicao(AtribuicaoDeCartao novaAC) {
        return true;
    }
    
}
