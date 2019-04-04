/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Interfaces;

import java.time.LocalDate;
import models.Colaborador;

/**
 *
 * @author mjdg1
 */
public interface Cartao {
    
    public boolean eDefinitivo();
    
    public boolean isCartao(int cartaoID);
    
    public boolean eProvisorio();
    
    public boolean validaAtribuicao(AtribuicaoDeCartao novaAC);
    
    public boolean registaAtribuicao(AtribuicaoDeCartao novaAC);
    
    public int getCartaoId();
    
    public Colaborador getColaboradorAtribuido(LocalDate date);
    
}
