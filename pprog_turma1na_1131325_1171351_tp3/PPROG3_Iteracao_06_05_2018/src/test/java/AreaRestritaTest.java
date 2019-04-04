
import models.AreaRestrita;
import models.Equipamento;
import models.PeriodoDeAutorizacao;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
/**
 *
 * @author Altran
 */
public class AreaRestritaTest {
    
    @Test
    public void addPeridoDeAutorizacaoTest() {
        
        //Arrange
        AreaRestrita areaRestrita = new AreaRestrita(10, 11, 5, 45, 25, 44);
        
        //Act
        areaRestrita.lotacaoPermiteAcesso("entrada");
        
        //Assert
        Assert.assertTrue(true);
    }
    
}
