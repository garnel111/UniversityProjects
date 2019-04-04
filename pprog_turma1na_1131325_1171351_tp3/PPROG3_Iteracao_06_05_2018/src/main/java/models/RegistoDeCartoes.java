/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Interfaces.AtribuicaoDeCartao;
import Interfaces.Cartao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mjdg1
 */
public class RegistoDeCartoes {

    private ArrayList<Cartao> cartoes;

    public RegistoDeCartoes(ArrayList<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public RegistoDeCartoes(){
        this.cartoes = new ArrayList<>();

    }

    public boolean registaCartao(CartaoIdentificacaoDefinitivo m_CartaoIdentificacao) {
        if (validaCartao(m_CartaoIdentificacao)) {
            return addCartao(m_CartaoIdentificacao);

        }
        return false;
    }

    public Cartao getCartao(String idCartao) {
        Cartao cartao = null;
        int idCartao1 = Integer.parseInt(idCartao);
        for (Cartao item : cartoes) {
            if (idCartao1 == item.getCartaoId()) {
                cartao = item;
            }

        }
        return cartao;

    }

    public Cartao getCartaoById(int idCartao) {
        for (Cartao itemCartao : cartoes) {
            if (itemCartao.getCartaoId() == idCartao) {
                return itemCartao;
            }
        }
        return null;
    }

    public ArrayList<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(ArrayList<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    private boolean validaCartao(CartaoIdentificacaoDefinitivo m_CartaoIdentificacao) {
        return true;
    }

    private boolean addCartao(CartaoIdentificacaoDefinitivo m_CartaoIdentificacao) {
        this.cartoes.add(m_CartaoIdentificacao);
        return true;
    }

}
