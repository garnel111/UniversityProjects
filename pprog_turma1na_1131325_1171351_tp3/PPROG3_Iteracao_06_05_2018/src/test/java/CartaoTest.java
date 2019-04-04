
import Interfaces.AtribuicaoDeCartao;
import Interfaces.Cartao;
import java.time.LocalDate;
import java.util.ArrayList;
import junit.framework.Assert;
import models.CartaoIdentificacaoDefinitivo;
import org.junit.Test;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
/**
 *
 * @author mjdg1
 */
public class CartaoTest {
    
    @Test
    public void validaColaboradorTest() {
        
        //Arrange
        CartaoIdentificacaoDefinitivo cartao = new CartaoIdentificacaoDefinitivo(1, LocalDate.MAX, 2);
        
        //Act
        cartao.getCartaoId();
        
        //Assert
        Assert.assertEquals(cartao.getCartaoId(), 1);
    }
}
