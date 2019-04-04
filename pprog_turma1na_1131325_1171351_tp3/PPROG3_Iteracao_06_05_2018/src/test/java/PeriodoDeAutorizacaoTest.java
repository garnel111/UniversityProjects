
import models.AreaRestrita;
import models.Empresa;
import models.Equipamento;
import models.PerfilDeAutorizacao;
import models.PeriodoDeAutorizacao;
import models.RegistoDeEquipamentos;
import models.RegistoPerfisDeAutorizacao;
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
public class PeriodoDeAutorizacaoTest {
    
    private RegistoDeEquipamentos registoDeEquipamentos;
    private Empresa m_Empresa;
    private RegistoPerfisDeAutorizacao registoPerfisDeAutorizacao;
    private PerfilDeAutorizacao perfilDeAutorizacao;
    private Equipamento equipamento;
    
    Equipamento equi1 = new Equipamento("1", "teste1", "tete1", "sFicheiroConfiguracao1", " novasc", "fabricante ", "entrada", new AreaRestrita());
    Equipamento equi2 = new Equipamento("2", "equi2a", "rews", "dasdsa", "novasc", "fabricante", "entrada", new AreaRestrita());
    Equipamento equi3 = new Equipamento("3", "equi23a", "re232ws", "da232sdsa", "novasc", "fabricante", "entrada", new AreaRestrita());
    
    PeriodoDeAutorizacao periododeAutorizacao1 = new PeriodoDeAutorizacao(2, "14:24", "14:33", equi1);
    
    PerfilDeAutorizacao perfilDeAutorizacao1 = new PerfilDeAutorizacao();
    
    @Test
    public void addPeridoDeAutorizacaoTest() {
        
        //Arrange
        Equipamento equi1 = new Equipamento("1", "teste1", "teste2", "sFicheiroConfiguracao1", " novasc", "fabricante ", "entrada", new AreaRestrita());
        
        //Act
        PeriodoDeAutorizacao periododeAutorizacao1 = new PeriodoDeAutorizacao(2, "14:24", "14:33", equi1);
        
        //Assert
        assertTrue(periododeAutorizacao1.getEquipamento().getId() == "1");
    }
    
}
