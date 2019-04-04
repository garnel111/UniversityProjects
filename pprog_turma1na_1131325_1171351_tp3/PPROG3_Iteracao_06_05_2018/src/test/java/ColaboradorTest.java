
import models.AreaRestrita;
import models.Colaborador;
import models.Equipamento;
import models.ListaPeriodosDeAutorizacao;
import models.PerfilDeAutorizacao;
import org.junit.Assert;
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
public class ColaboradorTest {
    
    @Test
    public void validaColaboradorTest() {
        
        //Arrange
        Equipamento equi1 = new Equipamento("1", "teste1", "tete1", "sFicheiroConfiguracao1", " novasc", "fabricante ", "entrada", new AreaRestrita());
        ListaPeriodosDeAutorizacao listaPeriodosDeAutorizacao1 = new ListaPeriodosDeAutorizacao();
        PerfilDeAutorizacao perfilDeAutorizacao = new PerfilDeAutorizacao("2", "decricao1", listaPeriodosDeAutorizacao1);
        Colaborador colaborador = new Colaborador(1, "Manuel Garnel", "Manuel", perfilDeAutorizacao);
        
        //Act
        boolean test = colaborador.validaColaborador(colaborador);
        
        //Assert
        Assert.assertFalse(test);
    }
}
