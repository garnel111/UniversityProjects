
import junit.framework.Assert;
import models.AreaRestrita;
import models.Equipamento;
import models.PerfilDeAutorizacao;
import models.PeriodoDeAutorizacao;
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
public class EquipamentoTest {
    
    @Test
    public void getListaDeEquipamentosTeste() {
        PerfilDeAutorizacao perfilDeAutorizacao = new PerfilDeAutorizacao();
        //Arrange
        Equipamento equi3 = new Equipamento("3", "equi23a", "re232ws", "da232sdsa", "novasc", "fabricante", "entrada", new AreaRestrita());
        
        //Act
        perfilDeAutorizacao = new PerfilDeAutorizacao("1", "descricao1");
        int diaDaSemana = 2;
        PeriodoDeAutorizacao periododeAutorizacao1 = new PeriodoDeAutorizacao(2, "14:24", "14:33", equi3);
        perfilDeAutorizacao.adicionaPeriodo(equi3, 2, "11:30", "11:59");
        //Assert
        System.out.println(equi3.valida());
        Assert.assertTrue(equi3.valida());
    }
}
